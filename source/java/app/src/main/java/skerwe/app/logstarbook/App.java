package skerwe.app.logstarbook;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class App {

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

        App application = new App();

        if (cmd.hasOption("c")) {
          System.out.printf("create new data sheet with name %s", cmd.getOptionValue("c"));
        }
        if (cmd.hasOption("o")) {
          System.out.printf("Open the data sheet with name %s", cmd.getOptionValue("o"));
        }
        if (cmd.hasOption("d")) {
          System.out.printf("Delete the data sheet with name %s", cmd.getOptionValue("d"));
        }

      } catch (ParseException | NumberFormatException e) {
        System.err.println("Parsing failed. Reason: " + e.getMessage());
        System.exit(1);
      }
    }

  }

  private static void printHelpAndUsage() {
    System.out.println();
    HelpFormatter formatter = new HelpFormatter();
    formatter.printHelp("sgen [command]", getOptions());
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
    return "\nSecrets Factory  Copyright (C) 2019  Quintin Henn\n"
        + "This program comes with ABSOLUTELY NO WARRANTY; for details type 'sgen -w'.\n"
        + "This is free software, and you are welcome to redistribute it\n"
        + "under certain conditions; type 'sgen -c' for details.";
  }

  private static String getVersionInfo() {
    return "\nVersion 0.1.0 (26-02-2022)";
  }
}
