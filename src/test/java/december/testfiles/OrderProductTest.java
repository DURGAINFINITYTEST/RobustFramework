package december.testfiles;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import december.testcomponents.DecBaseTest;
import pageObjects.LandingPage;
import pageObjects.OrderProductsPage;

public class OrderProductTest extends DecBaseTest {
	@Test(dataProvider = "getData")
	public void getOrderProduct(HashMap<String, String> input) throws InterruptedException, IOException {

		launchApplication();
		LandingPage lp = new LandingPage(driver);
		lp.goTo();
		lp.LoginApplication(input.get("email"), input.get("password"));
		Thread.sleep(1000);
		OrderProductsPage op = new OrderProductsPage(driver);
		op.getOrder();

	}

	@DataProvider
	public Object[][] getData() {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("email", "katakatladurgaprasad962@gmail.com");
		hm.put("password", "Chinna123");

		HashMap<String, String> hm1 = new HashMap<String, String>();
		hm1.put("email", "katakatladurgaprasad962@gmail.com");
		hm1.put("password", "Chinna123");
		return new Object[][] { { hm }, { hm1 } };

	}

}
