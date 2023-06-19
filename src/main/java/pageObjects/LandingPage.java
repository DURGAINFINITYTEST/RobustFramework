package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LandingPage {
	WebDriver driver;

	public LandingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@formcontrolname='userEmail']")
	WebElement userName;

	@FindBy(xpath = "//input[@formcontrolname='userPassword']")
	WebElement getPassword;

	@FindBy(id = "login")
	WebElement login;

	public void LoginApplication(String mail, String password) {
		userName.sendKeys(mail);
		getPassword.sendKeys(password);
		login.click();

	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");

	}

}
