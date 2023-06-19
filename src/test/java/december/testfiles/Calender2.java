package december.testfiles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)");

		WebElement currentMonth = driver.findElement(
				By.cssSelector("form[class='elementor-form'] input[name='form_fields[travel_comp_date]']"));

		driver.findElement(By.cssSelector("form[class='elementor-form'] input[name='form_fields[travel_comp_date]']"))
				.click();

//		while (!currentMonth.getText().equalsIgnoreCase("August")) {
//
//			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
//
//		}

		List<WebElement> dates = driver.findElements(By.cssSelector(".flatpickr-day"));
		System.out.println(driver.findElements(By.cssSelector(".flatpickr-day")).size());

		for (int i = 0; i < dates.size(); i++) {

			String alldates = dates.get(i).getText();
			if (alldates.equalsIgnoreCase("27")) {

				dates.get(i).click();
				break;

			}
		}

	}

}
