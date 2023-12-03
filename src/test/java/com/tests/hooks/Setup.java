package com.tests.hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;

import com.tests.constants.DriverType;
import com.tests.factory.DriverManagerFactory;
import com.tests.utils.ConfigFileReader;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.net.MalformedURLException;

/**
 * @author Zied Hannachi
 **/

public class Setup {

	private static WebDriver driver;
	private static final Logger LOGGER = (Logger) LogManager.getLogger(Setup.class.getName());
	final ConfigFileReader configFileReader = new ConfigFileReader();

	/**
	 * This method is used to open browser. This method is called before the
	 * invocation of each test method in the given class. In this method we need to
	 * pass browser name which will invoke the respective driver.
	 * 
	 * @throws MalformedURLException the malformed URL exception
	 * @Before Methods annotated with @Before will execute before every scenario.
	 */
	@Before
	public void startDriver(Scenario scenario) throws MalformedURLException {

		LOGGER.info("Scenario: " + scenario.getName() + " - started");

		String browser = System.getProperty("browser", String.valueOf(DriverType.CHROME));
		driver = DriverManagerFactory.getManager(DriverType.valueOf(browser)).createDriver();

	}

	/* GETTER */
	public static WebDriver getDriver() {
		return driver;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public static void setDriver(WebDriver driver) {
		Setup.driver = driver;
	}

}
