package skerwe.app.logstarbook;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import skerwe.app.logstarbook.engine.ApplicationController;

/**
 * Application to track numbers for an object on a spreadsheet.
 * For example logging the amount of books your kids read, so they can be rewarded after predetermined amount of books.
 *
 * @author Quintin Henn
 * @since 29.02.2022
 * @version 09.04.2022
 */
public class Application {

  private static Logger logger = LogManager.getLogger();

  private static final String VERSION = "Version 0.1.0 (09-04-2022)";

  private Application() {}

  /**
   * Open or creates a new sheet based on the command line arguments.
   * Prints version, license, help and useage information.
   * @param args command line arguments for sheet configuration
   */
  public static void main(String[] args) {

    System.out.println(getLicense());

    if (args.length == 0) {
      printHelpAndUsage();
    } else {

      try {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(getOptions(), args);

        if (cmd.getOptions().length == 0) {
          printHelpAndUsage();
          return;
        }

        if (cmd.hasOption("help")) {
          printHelpAndUsage();
          return;
        }
        if (cmd.hasOption("version")) {
          System.out.println(getVersionInfo());
          return;
        }

        Application app = new Application();

        if (cmd.hasOption("c")) {
          ApplicationController.getInstance().create(cmd.getOptionValue("c"));
          System.out.printf("create new data sheet with name %s%n", cmd.getOptionValue("c"));
        }
        if (cmd.hasOption("o")) {
          ApplicationController.getInstance().open(cmd.getOptionValue("o"));
          System.out.printf("Open the data sheet with name %s%n", cmd.getOptionValue("o"));
        }
        if (cmd.hasOption("d")) {
          ApplicationController.getInstance().delete(cmd.getOptionValue("d"));
          System.out.printf("Delete the data sheet with name %s%n", cmd.getOptionValue("d"));
        }

      } catch (ParseException | NumberFormatException e) {
        System.err.println("Parsing failed. Reason: " + e.getMessage());
        System.exit(1);
      }
    }
    System.out.println();
  }

  private static void printHelpAndUsage() {
    System.out.println();
    HelpFormatter formatter = new HelpFormatter();
    formatter.printHelp("logstarbook [command]", getOptions());
  }

  private static Options getOptions() {
    Option help = new Option("h", "help", false, "print this usage message");
    Option version = new Option("v", "version", false, "print the version information");

    Option create = Option.builder("c")
        .longOpt("create")
        .argName("name")
        .hasArg()
        .desc("create a new track sheet")
        .build();

    Option open = Option.builder("o")
        .longOpt("open")
        .argName("name")
        .hasArg()
        .desc("open the named track sheet")
        .build();

    Option delete = Option.builder("d")
        .longOpt("delete")
        .argName("name")
        .hasArg()
        .desc("delete the named track sheet")
        .build();

    Options options = new Options();
    options.addOption(help);
    options.addOption(version);
    options.addOption(create);
    options.addOption(open);
    options.addOption(delete);

    return options;
  }

  private static String getLicense() {
    return "\nLOGSTARBOOK\n\n" +
        "Copyright (c) 2022 Quintin Henn\n\n" +
        "Permission is hereby granted, free of charge, to any person obtaining a copy\n" +
        "of this software and associated documentation files (the \"Software\"), to deal\n" +
        "in the Software without restriction, including without limitation the rights\n" +
        "to use, copy, modify, merge, publish, distribute, sublicense, and/or sell\n" +
        "copies of the Software, and to permit persons to whom the Software is\n" +
        "furnished to do so, subject to the following conditions:\n\n" +
        "The above copyright notice and this permission notice shall be included in all\n" +
        "copies or substantial portions of the Software.\n\n" +
        "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\n" +
        "IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\n" +
        "FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE\n" +
        "AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\n" +
        "LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\n" +
        "OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE\n" +
        "SOFTWARE.\n\n";
  }

  private static String getVersionInfo() {
    return VERSION;
  }
}
