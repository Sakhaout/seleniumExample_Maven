package com.crmpro.utilites;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crmpro.baseClass.BasePage;


public class CustomListener extends BasePage implements ITestListener {
	
	private TestUtile testUtile_obj = new TestUtile();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("FAILED Test");
		testUtile_obj.takeScreenshot(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The test Skipped");

		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {

		// TODO Auto-generated method stub
		
	}

}
