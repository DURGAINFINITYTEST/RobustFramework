package december.testfiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOverIntercation {

	@Test
	public void MouseOverInteraction() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Actions ac = new Actions(driver);

		driver.switchTo().frame("iframe-name");

		driver.findElement(By.xpath("//a[text()='Mentorship']")).click();
		driver.switchTo().defaultContent();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebDriverWait obj = new WebDriverWait(driver, Duration.ofSeconds(10));
		obj.until(ExpectedConditions.visibilityOfElementLocated(null));

	}

}
