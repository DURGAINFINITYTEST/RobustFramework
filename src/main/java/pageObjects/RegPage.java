package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegPage {
	WebDriver driver;

	public RegPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//p[@class='login-wrapper-footer-text']")
	WebElement Register;
	@FindBy(xpath = "//input[@id='firstName']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lastName;
	@FindBy(id = "userEmail")
	WebElement mailId;
	@FindBy(xpath = "//input[@placeholder='enter your number']")
	WebElement Number;
	@FindBy(xpath = "//select[@formcontrolname='occupation']")
	WebElement Profession;
	@FindBy(xpath = "//input[@value='Male']")
	WebElement gender;
	@FindBy(id = "userPassword")
	WebElement password;
	@FindBy(id = "confirmPassword")
	WebElement conformPassword;
	@FindBy(id = "login")
	WebElement RegisterClick;

	public void Registration() {
		Register.click();
		FirstName.sendKeys("durga");
		lastName.sendKeys("prasad");
		mailId.sendKeys("katakatladurgaprasad962@gmail.com");
		Number.sendKeys("9966019169");
		Select obj = new Select(Profession);
		obj.selectByVisibleText("Engineer");
		gender.click();
		password.sendKeys("Chinna123");
		conformPassword.sendKeys("Chinna123");
		RegisterClick.click();
		

	}

}
