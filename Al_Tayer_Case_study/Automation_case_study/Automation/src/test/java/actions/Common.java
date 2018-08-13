package actions;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinition.TestRunner;

public class Common extends TestRunner {

	// public static WebDriver driver = new FirefoxDriver();
	static Capabilities caps = DesiredCapabilities.firefox();

	public static DesiredCapabilities capabilities;

	static WebDriverWait wait = null;
	public static WebDriver driver;

	public static void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("excludeSwitches", "enable-automation");
		options.setExperimentalOption("prefs", prefs);
		capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("version", "latest");
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	}

	public static void open_URL(String URL) throws InterruptedException {

		driver.get(URL);
		Thread.sleep(3000);

	}

	public static String getValue(String input) throws IOException {

		FileReader reader = new FileReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\configuration\\confi.properties");
		Properties prop = new Properties();
		prop.load(reader);
		String getProp = prop.getProperty(input);

		return getProp;
	}

	public static void exitBrowser() {
		driver.quit();
	}

	public static void scenarioName(String testName, String description) {

		extentTest = extentReports.startTest(testName, description);

	}

	public static WebElement waitForElement(WebElement element) {

		try {

			wait = new WebDriverWait(driver, 40000);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception

			System.err.println(e.getStackTrace());

		}
		return element;

	}

}
