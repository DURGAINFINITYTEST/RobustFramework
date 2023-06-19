package december.testfiles;

import org.testng.annotations.Test;

public class Testng {
	@Test(expectedExceptions = Exception.class)
	public void getTestNG() {

		int[] s = { 1, 2, 3, 4, 5, 6 };

		System.out.println(s[8]);
		System.out.println("chinna");

	}

}
