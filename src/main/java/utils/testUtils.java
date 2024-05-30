package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testUtils {
	WebDriver driver;
	public void waitforElementTobeClickable(WebElement element)
	{
		System.out.println("in explicit wait");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10000));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		System.out.println("out of explicit");
	}


	public void selectFromDropDown(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
}
