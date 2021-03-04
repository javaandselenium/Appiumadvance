package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Test6 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities d=new DesiredCapabilities();
		d.setCapability(MobileCapabilityType.DEVICE_NAME,"grb");
		d.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
		d.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
		d.setCapability("adbExecTimeout","40000");
		d.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.androidsample.generalstore");
		d.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.androidsample.generalstore.SplashActivity");
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url, d);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("john");
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	Thread.sleep(9000);
	Set<String> apps = driver.getContextHandles();
	
	for(String app:apps) {
		System.out.println(app);
	}
	Thread.sleep(5000);
	driver.context("WEBVIEW_com.androidsample.generalstore");
	driver.findElement(By.name("q")).sendKeys("phone");
//	driver.context("NATIVE_APP");
	
	
	}

}
