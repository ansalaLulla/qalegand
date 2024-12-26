package testClasses;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import extentReport.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;

public class BaseClass {

	public static WebDriver driver;

	public static Properties p;

	public static void readProperty() throws IOException {
		p = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Config.properties");
		p.load(fs);
	}

	@BeforeMethod(groups = {"Launch"})
	@Parameters("browser")
	public void beforeMethod(String browserValue) throws IOException {
		readProperty();

		if (browserValue.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserValue.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
            throw new IllegalArgumentException("Browser not supported: " + browserValue);
        }

		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));

	}
	
	
	@BeforeSuite
	public void createReport() {
	    ExtentManager.createInstance();
	}


	@AfterMethod(groups = {"Close"})
	public void afterMethod() {

		driver.quit();
	}

}
