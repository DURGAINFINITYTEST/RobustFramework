package december.testfiles;

import java.io.IOException;

import org.testng.annotations.Test;

import december.testcomponents.DecBaseTest;
import pageObjects.LandingPage;
import pageObjects.RegPage;

public class RegistrationTest extends DecBaseTest {
	@Test
	public void getRegistration() throws IOException, InterruptedException {
		launchApplication();
		LandingPage lp = new LandingPage(driver);
		lp.goTo();
		Thread.sleep(3000);
		RegPage rp = new RegPage(driver);
		rp.Registration();

	}

}
