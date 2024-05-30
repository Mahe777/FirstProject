package test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;

public class BaseTest {

	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	ExtentTest logger;

	@BeforeTest
	public void beforeTest()
	{


	}
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String browser, Method testMethod) throws IOException
	{
		// Create object of SimpleDateFormat class and decide the format
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy HHmmss");
		//get current date time with Date()
		Date date = new Date();
		// Now format the date
		String date1= dateFormat.format(date);

		sparkReporter = new ExtentSparkReporter("E:"+ File.separator+"Automation"+ File.separator+"Selenium Automation"+ File.separator+"Practice Automation"+ File.separator+"FirstProjectResults"+ File.separator+"reports"+File.separator+testMethod.getName()+" "+date1+".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("HostName","DESKTOP-N0F0MUS");
		extent.setSystemInfo("UserName","root");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("test Results");

		setupDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		String ss = captureScreenshot();
		
		logger= extent.createTest(testMethod.getName()).info("test info")
				.info(MediaEntityBuilder.createScreenCaptureFromBase64String(ss).build());

	}

	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ "- Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+ "- Test Case Failed", ExtentColor.RED));
		}
		else if (result.getStatus() == ITestResult.SKIP)
		{
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ "- Test Case Skipped", ExtentColor.ORANGE));
		}
		else if (result.getStatus() == ITestResult.SUCCESS)
		{
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ "- Test Case Passed", ExtentColor.GREEN));
		}
		driver.quit();

	}
	@AfterTest
	public void afterTest()
	{
		extent.flush();
	}


	public void setupDriver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().clearDriverCache().setup();
			WebDriverManager.chromedriver().clearResolutionCache().setup();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}

	public static String captureScreenshot(String fileName) throws IOException
	{
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots/"+fileName);
		FileUtils.copyFile(sourceFile,destFile);
		System.out.println("ss taken");
		return destFile.getAbsolutePath();
	}

	public static String captureScreenshot() throws IOException
	{
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		String base64code = takesScreenshot.getScreenshotAs(OutputType.BASE64);
		System.out.println("ss taken");
		return base64code;
	}
}
