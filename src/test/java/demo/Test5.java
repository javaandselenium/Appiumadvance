package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Test5 {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities d=new DesiredCapabilities();
		d.setCapability(MobileCapabilityType.DEVICE_NAME,"grb");
		d.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
		d.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
		d.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url, d);
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		driver.get("https://www.linkedin.com/");
		driver.findElement(By.id("session_key")).sendKeys("admindttyadtyh");
		driver.findElement(By.id("session_password")).sendKeys("gyfhghhshfgghfgfgg");
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')")).click();
		
	}

}
