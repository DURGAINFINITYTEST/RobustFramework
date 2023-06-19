package Resourses;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	static ExtentReports rp;

	@BeforeTest
	public static ExtentReports config() {

		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web automation results");
		reporter.config().setDocumentTitle("Test results");

		rp = new ExtentReports();
		rp.attachReporter(reporter);
		rp.setSystemInfo("tester", "durga prasad katakatala");
		return rp;

	}

}
