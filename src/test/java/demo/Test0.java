package demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Test0 {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities d=new DesiredCapabilities();
		d.setCapability(MobileCapabilityType.DEVICE_NAME,"grb");
		d.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
		d.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
		d.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.banggood.client");
		d.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.banggood.client.module.home.MainActivity");
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url, d);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Electronics']")).click();

	}

}
