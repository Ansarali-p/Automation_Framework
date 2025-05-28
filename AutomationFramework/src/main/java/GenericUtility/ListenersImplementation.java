package GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---Started");
		test = report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---Passed");
		test.log(Status.PASS, methodname + "---PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---Failed");
		test.log(Status.FAIL, methodname + "---Fail");
		test.log(Status.INFO, result.getThrowable());// reason to fail
		WebDriverUtility wutil = new WebDriverUtility();
		Java_Utility jutil = new Java_Utility();
		String screenshotname = methodname+"-"+jutil.toGetSystemDateAndTime();
		try {
			String path = wutil.toTakeScreenShot(BassClass.sDriver, screenshotname);
			test.addScreenCaptureFromPath(path);// to add ss to report
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---Skipped");
		test.log(Status.SKIP, methodname + "---Skip");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("---Suite Execution Started---");
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentsReports/Report-"+new Java_Utility().toGetSystemDateAndTime()+".html");
		htmlReport.config().setDocumentTitle("VITIGER EXTENTS REPORTS");
		htmlReport.config().setReportName("Vitiger Extents Reports");
		htmlReport.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("URL", "http://localhost.8888/");
		report.setSystemInfo("USERNAME", "admin");
		report.setSystemInfo("PASSWORD", "password");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("---Suite Execution Finished---");
		report.flush();
	}
	

}
