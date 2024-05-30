package PageEvents;



import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.codeborne.selenide.Driver;
import com.sun.tools.sjavac.Log;

import jdk.jfr.internal.Logger;
import pageObjects.HomePageElements;
import test.BaseTest;
import utils.ElementFetch;

public class HomePageEvents extends BaseTest {


	
	ElementFetch ele = new ElementFetch();
	utils.testUtils testUtils = new utils.testUtils();
	
	public void launchURL()
	{
	//	testUtils.waitforElementTobeClickable(ele.getWebElement("XPATH", HomePageElements.mainURL));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
//		ele.getWebElement("XPATH", HomePageElements.mainURL).click();
		String actualvalue = ele.getWebElement("XPATH", HomePageElements.urlLaunchvalidation).getText();
		Assert.assertEquals(actualvalue, "CATEGORY");
		System.out.println("url is launched");
	}
	
	public void clickSignUporLogin()
	{
		ele.getWebElement("XPATH", HomePageElements.signUporLogin).click();
		String actualvalue = ele.getWebElement("XPATH", HomePageElements.signupPage).getText();
		Assert.assertEquals(actualvalue, "New User Signup!");
		System.out.println("login/SignUp page is launched");
	}
	
	public void signupSuccessful()
	{
		ele.getWebElement("XPATH", HomePageElements.signupName).sendKeys("Mahe");
		ele.getWebElement("XPATH", HomePageElements.signupEmail).sendKeys("Mahe2@gmail.com");
		ele.getWebElement("XPATH", HomePageElements.signupButton).submit();
		String actualvalue = ele.getWebElement("XPATH", HomePageElements.enterAccInfoPage).getText();
		Assert.assertEquals(actualvalue, "ENTER ACCOUNT INFORMATION");
		System.out.println("Enter acc info page is launched");
		ele.getWebElement("XPATH", HomePageElements.titleMr).click();
		ele.getWebElement("XPATH", HomePageElements.password).sendKeys("Mahe");
		testUtils.selectFromDropDown(ele.getWebElement("XPATH", HomePageElements.day), "20");
		testUtils.selectFromDropDown(ele.getWebElement("XPATH", HomePageElements.month), "12");
		testUtils.selectFromDropDown(ele.getWebElement("XPATH", HomePageElements.year), "1995");
		
		ele.getWebElement("XPATH", HomePageElements.firstname).sendKeys("Mahendra");
		ele.getWebElement("XPATH", HomePageElements.lastname).sendKeys("Muram");
		ele.getWebElement("XPATH", HomePageElements.company).sendKeys("My company");
		ele.getWebElement("XPATH", HomePageElements.address).sendKeys("Simhapuri");
		ele.getWebElement("XPATH", HomePageElements.address2).sendKeys("Bachupally");
		testUtils.selectFromDropDown(ele.getWebElement("XPATH", HomePageElements.country), "Canada");
		ele.getWebElement("XPATH", HomePageElements.state).sendKeys("Telangana");
		ele.getWebElement("XPATH", HomePageElements.city).sendKeys("Hyderabad");
		ele.getWebElement("XPATH", HomePageElements.zipcode).sendKeys("500094");
		ele.getWebElement("XPATH", HomePageElements.mobileNumber).sendKeys("9473847589");
		ele.getWebElement("XPATH", HomePageElements.submit).submit();
		
	}
	
}

