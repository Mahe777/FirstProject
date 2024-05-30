package PageEvents;

import org.testng.Assert;

import pageObjects.HomePageElements;
import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents {

	ElementFetch ele = new ElementFetch();
	utils.testUtils testUtils = new utils.testUtils();
	
	public void loginNegativeScenario()
	{
		ele.getWebElement("XPATH", HomePageElements.signUporLogin).click();
		String actualvalue = ele.getWebElement("XPATH", LoginPageElements.loginPage).getText();
		Assert.assertEquals(actualvalue, "Login to your account");
		System.out.println("login/SignUp page is launched");
		
		ele.getWebElement("XPATH", LoginPageElements.signupEmail).sendKeys("Mahe4@mail.com");
		ele.getWebElement("XPATH", LoginPageElements.password).sendKeys("test");
		ele.getWebElement("XPATH", LoginPageElements.submit).submit();
		String loginFailed = ele.getWebElement("XPATH", LoginPageElements.loginfailedText).getText();
	}
}
