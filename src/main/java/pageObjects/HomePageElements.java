package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public interface HomePageElements {
	
	String TestCase1 = "//u[normalize-space()='Test Case 1: Register User']";
	String mainURL = "//div[@id='collapse1']//a";
    String urlLaunchvalidation ="//h2[contains(text(),'Category')]";
    String signUporLogin ="//a[contains(text(),'Signup')]";
    String signupPage = "//h2[contains(text(),'New User')]";
    String signupName="//input[@name='name']";
    String signupEmail="//form[@action='/signup']//input[@name='email']";
    String signupButton="//input[@value='signup']";
    String enterAccInfoPage ="//b[contains(text(),'Enter')]";
    String titleMr ="//input[@type='radio' and @value='Mr']";
    String titleMrs ="//input[@type='radio' and @value='Mrs']";
    String password ="//input[@type='password']";
    String day="//select[@name='days']";
    String month ="//select[@name='months']";
    String year = "//select[@name='years']";
    String firstname ="//input[@id='first_name']";
    String lastname= "//input[@id='last_name']";
    String company = "//input[@id='company']";
    String address = "//input[@id='address1']";
    String address2 = "//input[@id='address2']";
    String country ="//select[@id='country']";
    String state = "//input[@id='state']";
    String city = "//input[@id='city']";
    String zipcode = "//input[@id='zipcode']";
    String mobileNumber = "//input[@id='mobile_number']";
    String submit = "//form[@action=\"/signup\"]//button[@type='submit']";
}
