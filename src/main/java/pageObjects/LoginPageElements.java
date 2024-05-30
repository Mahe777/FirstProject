package pageObjects;

public interface LoginPageElements {

	String loginPage = "//h2[contains(text(),'Login')]";
	String signupEmail="//form[@action='/signup']//input[@name='email']";
	String password ="//input[@type='password']";
	String submit = "//form[@action=\"/login\"]//button[@type='submit']";
	String loginfailedText = "//form[@action=\"/login\"]//p";
}
