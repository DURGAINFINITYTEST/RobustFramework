package december.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Return;
import pageObjects.LandingPage;

public class DecBaseTest {
	Properties prop;
	FileInputStream fis;
	protected WebDriver driver;

	public WebDriver initilizeFirst() throws IOException {

		prop = new Properties();
		fis = new FileInputStream(
				"C:\\Users\\katak\\eclipse-workspace\\DecemberProject\\src\\main\\java\\Resourses\\Global.Properties");
		prop.load(fis);
		String BrowserName = prop.getProperty("browser");

		if (BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (BrowserName.equalsIgnoreCase("firfox")) {
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();

		} else if (BrowserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			WebDriver driver = new EdgeDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}

	public String getScreenshot(String TestCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File desFile = new File(System.getProperty("user.dir") + "//reports//" + TestCaseName + ".png");
		FileUtils.copyFile(srcFile, desFile);
		return System.getProperty("user.dir") + "//reports//" + TestCaseName + ".png";

	}

	public List<HashMap<String, String>> getJsonDataToMap(String string) throws IOException {

		@SuppressWarnings("deprecation")
		String json = FileUtils.readFileToString(new File(string), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(json, new TypeReference<List<HashMap<String, String>>>() {
		});
		return data;

	}

	public void launchApplication() throws IOException {

		driver = initilizeFirst();

	}
}
