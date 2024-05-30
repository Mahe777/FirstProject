package qa.Tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

import PageEvents.HomePageEvents;
import PageEvents.LoginPageEvents;
import test.BaseTest;
import utils.ElementFetch;

public class TestCase1 extends BaseTest{
	
	ElementFetch ele = new ElementFetch();
	HomePageEvents homepage = new HomePageEvents();
	LoginPageEvents loginpage = new LoginPageEvents();
	
	

//  public void testCase1(Method testMethod) throws IOException {
//
//	  homepage.launchURL();
//	  homepage.clickSignUporLogin();
//	  homepage.signupSuccessful();
//	  
//  }
  
  @Test
  public void testCase3(Method testMethod) throws IOException {

	loginpage.loginNegativeScenario();
	  
  }
}
