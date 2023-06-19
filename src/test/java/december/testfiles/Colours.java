package december.testfiles;

import java.awt.Color;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Colours {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.flipkart.com/valentine-day-store?param=98574&otracker=hp_bannerads_1_2.bannerAdCard.BANNERADS_a_STNCGSWAOROT");
		driver.manage().window().maximize();
		WebElement s = driver.findElement(By.className("_1rH5Jn"));
		String colourvalue = s.getCssValue("background-color");
		System.out.println(colourvalue);
		System.out.println(org.openqa.selenium.support.Color.fromString(colourvalue).asHex());

	}

}
