package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderProductsPage {
	WebDriver driver;

	public OrderProductsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")

	WebElement checkout;

	@FindBy(css = "li[class='totalRow'] button[type='button']")
	WebElement button;
	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement cvv;
	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement nameOfTheCard;

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countryName;

	@FindBy(css = ".btnn.action__submit.ng-star-inserted")
	WebElement orderTheProduct;

	public void getOrder() throws InterruptedException {

		WebElement disiredProduct = products.stream().filter(
				product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("adidas original"))
				.findFirst().orElse(null);
		disiredProduct.findElement(By.cssSelector(".btn.w-10.rounded")).click();
		Thread.sleep(2000);
		checkout.click();
		button.click();
		cvv.sendKeys("429");
		nameOfTheCard.sendKeys("durga prasad");
		countryName.sendKeys("ind");
		List<WebElement> countrys = driver.findElements(By.cssSelector(".ta-item.list-group-item.ng-star-inserted"));
		for (WebElement country : countrys) {
			if (country.getText().equalsIgnoreCase("india")) {
				country.click();
				break;

			}
		}

		orderTheProduct.click();
	}

}
