package com.tests.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager implements DriverManager {

	@Override
	public WebDriver createDriver() {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		return driver;
	}
}