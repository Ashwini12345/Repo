package com.vtiger.listener;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.vtiger.genericlib.Driver;

public class Listener implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
      String testname=result.getMethod().getMethodName();
		EventFiringWebDriver efw=new EventFiringWebDriver(Driver.driver);
		File srcImg=efw.getScreenshotAs(OutputType.FILE);
		File desIMG=new File("E:\\programs\\workspace\\SeleniumProject\\Ashwini\\Vtiger\\screenshot\\"+testname+".png");
		try{
			FileUtils.copyFile(srcImg, desIMG);
		}
		catch(Throwable e){
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
