package december.testfiles;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import december.testcomponents.DecBaseTest;
import pageObjects.AddToCartPage;
import pageObjects.LandingPage;

@Test(dataProvider = "getdata1")
public class AddToCartTest extends DecBaseTest {

	public void getAddToCart(HashMap<String, String> input1) throws InterruptedException, IOException {
		String s = "adidas original";
		launchApplication();
		LandingPage lp = new LandingPage(driver);
		lp.goTo();
		lp.LoginApplication(input1.get("email"), input1.get("password"));
		Thread.sleep(1000);
		AddToCartPage ac = new AddToCartPage(driver);
		ac.getAddToCart(input1.get("ProductName"));

	}

	@DataProvider
	public Object[][] getdata1() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\december\\data\\addTocart.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
