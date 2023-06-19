package december.testfiles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.abhibus.com/");
		driver.findElement(By.id("datepicker1")).click();
		driver.findElement(By.cssSelector(".ui-datepicker-group.ui-datepicker-group-first")).click();

		WebElement jan = driver.findElement(By.cssSelector(".ui-datepicker-group.ui-datepicker-group-first"));
		List<WebElement> dates = jan.findElements(By.cssSelector(".ui-state-default"));
		System.out.println(jan.findElements(By.cssSelector(".ui-state-default")).size());

		for (int i = 0; i < dates.size(); i++) {

			String alldates = dates.get(i).getText();
			if (alldates.equalsIgnoreCase("27")) {

				dates.get(i).click();
				break;

			}
		}
//target some month and year
		
	}

}
