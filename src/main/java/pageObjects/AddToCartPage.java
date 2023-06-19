package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.Abstract;

public class AddToCartPage extends Abstract {
	WebDriver driver;

	public AddToCartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	By listOfProducts = By.cssSelector(".mb-3");
	By toast = By.cssSelector(".ng-tns-c31-1.ng-star-inserted");

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cart;

	@FindBy(css = "div[class='cartSection'] h3")
	List<WebElement> cartPro;

	public void getAddToCart(String pName) throws InterruptedException {
		WebElementToAppear(listOfProducts);
		List<WebElement> listOfProducts = driver.findElements(By.cssSelector(".mb-3"));
		WebElement disiredProduct = listOfProducts.stream().filter(
				product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("adidas original"))
				.findFirst().orElse(null);
		disiredProduct.findElement(By.cssSelector(".btn.w-10.rounded")).click();
		WebElementToAppear(toast);
		Thread.sleep(1000);
		cart.click();
		boolean value = cartPro.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(pName));

	}

}
