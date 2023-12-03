package com.tests.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements DriverManager {

	@Override
	public WebDriver createDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("force-device-scale-factor=0.75");
		WebDriver driver = new ChromeDriver(chromeOptions);
		return driver;
	}
}
