package december.testfiles;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import december.testcomponents.DecBaseTest; 
import pageObjects.LandingPage;

public class LoginTest extends DecBaseTest {
	@Test(dataProvider = "getLoginData")
	public void getLogin(HashMap<String, String> in) throws IOException {

		launchApplication();
		LandingPage lp = new LandingPage(driver);
		lp.goTo();
		lp.LoginApplication(in.get("emai"), in.get("password"));

	}

	@DataProvider
	public Object[][] getLoginData() throws IOException {

		List<HashMap<String, String>> dat = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\december\\data\\Login.data");

		return new Object[][] { { dat.get(0) }, { dat.get(1) } };

	}
}
