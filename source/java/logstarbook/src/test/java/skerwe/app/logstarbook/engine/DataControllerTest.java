package skerwe.app.logstarbook.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Properties;
import java.util.Optional;

public class DataControllerTest {

  @Test
  void loadProperties() {
    DataController classUnderTest = new DataController();
    Optional<Properties> properties = classUnderTest.loadProperties();

    assertTrue(properties.isPresent(), "Properties should have been loaded.");
    assertNotNull(properties.get().getProperty("data.fileLocation"), "Properties should have the data file locaton.");
  }

  @Test
  void load() {
    DataController classUnderTest = new DataController();
  }

  @Test
  void save() {
    DataController classUnderTest = new DataController();
  }
}
