package com.tests.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tests.hooks.Setup;

/**
 * This class contains the declaration of the driver. and contains the
 * declaration of the logger.
 */
public class BasePage {

	protected WebDriver driver;
	protected static WebDriverWait wait;

	/**
	 * Instanciation de base page.
	 * 
	 * @param driver
	 */
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * methode Wait for element to be clickable
	 *
	 * @param locator
	 */
	public static void waitForElementToBeClickable(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * methode Wait for element to be visible
	 *
	 * @param locator
	 */
	public static void waitForElementToBeVisible(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(locator));
	}

	public void waitForOverlaysToDisappear(By overlay) {
		List<WebElement> overlays = Setup.getDriver().findElements(overlay);
		if (overlays.size() > 0) {
			wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
		}
	}
}
