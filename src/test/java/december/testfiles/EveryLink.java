package december.testfiles;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EveryLink {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://abstracta.us/blog/software-testing/best-demo-websites-for-practicing-different-types-of-software-tests/");
		System.out.println(driver.findElements(By.tagName("a")).size());

		WebElement columnList = driver.findElement(By.cssSelector(".widget-item.widget_categories"));

		System.out.println(columnList.findElement(By.tagName("a")).getSize());
		List<WebElement> allLinks = columnList.findElements(By.tagName("a"));

		int i = 1;
		for (i = 1; i < columnList.findElements(By.tagName("a")).size(); i++) {

			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			Thread.sleep(3000);
			columnList.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);

			Set<String> window = driver.getWindowHandles();
			Iterator<String> it = window.iterator();
			while (it.hasNext()) {
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}

		}

	}

}
