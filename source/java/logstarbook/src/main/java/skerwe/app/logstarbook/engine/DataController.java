package skerwe.app.logstarbook.engine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileReader;
import java.util.Properties;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import skerwe.app.logstarbook.Application;
import skerwe.app.logstarbook.model.LogStarBookModel;

/**
 * Utility to laod the application configuration properties, also to read and write JSON.
 * This is the save manager utitlity which saves the application data to JSON.
 *
 * @author Quintin Henn
 * @since 09.04.2022
 * @version 09.04.2022
 */
public class DataController {

  private static Logger logger = LogManager.getLogger();

  public Optional<Properties> loadProperties() {
    try (InputStream inputStream = Application.class.getClassLoader().getResourceAsStream("config.properties")) {

      Properties properties = new Properties();
      properties.load(inputStream);

      return Optional.of(properties);

    } catch (IOException exception) {
      logger.warn(exception.getMessage(), exception);
    }

    return Optional.empty();
  }

  public Optional<LogStarBookModel> load(String dataFileLocation) {
    try (JsonReader reader = new JsonReader(new FileReader(dataFileLocation))) {

      Gson gson = new Gson();
      LogStarBookModel LogStarBookData = gson.fromJson(reader, LogStarBookModel.class);
      return Optional.of(LogStarBookData);

    } catch (IOException exception) {
      logger.warn(exception.getMessage(), exception);
    }

    return Optional.empty();
  }

  public void save(LogStarBookModel model) {
    Gson gson = new Gson();
    String json = gson.toJson(model);
  }

}
