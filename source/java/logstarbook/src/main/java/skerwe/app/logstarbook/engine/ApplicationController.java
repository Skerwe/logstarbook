package skerwe.app.logstarbook.engine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Controller for application logic.
 *
 * @author Quintin Henn
 * @since 09.04.2022
 * @version 09.04.2022
 */
public class ApplicationController {

  private static Logger logger = LogManager.getLogger();

  private static final ApplicationController controller = new ApplicationController();

  private ApplicationController() {}

  public static ApplicationController getInstance() {
    return controller;
  }

  public void create(String title) {}

  public void open(String title) {}

  public void delete(String title) {}

}
