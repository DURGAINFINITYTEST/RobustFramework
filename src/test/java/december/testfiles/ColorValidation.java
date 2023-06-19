package december.testfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ColorValidation {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.example.com");

		WebElement element = driver.findElement(By.id("elementId"));
		String actualColor = element.getCssValue("color");
		String expectedColor = "rgba(255, 0, 0, 1)";

		if (actualColor.equals(expectedColor)) {
			System.out.println("Color match");
		} else {
			System.out.println("Color does not match");
		}

		driver.quit();
	}
}
