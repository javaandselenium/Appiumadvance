package demo;

import java.io.File;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	public AppiumDriverLocalService service;
	@BeforeSuite
	public void startappiumserver() {
		 service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
		.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
		.withAppiumJS(new 
		File("C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js")));
	service.start();
	}
	
	@AfterSuite
	public void closeservice() {
		service.stop();
	}

}
