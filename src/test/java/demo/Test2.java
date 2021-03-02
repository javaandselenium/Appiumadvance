package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Test2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities d=new DesiredCapabilities();
		d.setCapability(MobileCapabilityType.DEVICE_NAME,"grb");
		d.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
		d.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
		d.setCapability("adbExecTimeout","40000");
		d.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.appium.android.apis");
		d.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"io.appium.android.apis.ApiDemos");
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url, d);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//find the complete window size
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		Thread.sleep(5000);
		Dimension s = driver.manage().window().getSize();
		//get the height of the phone
		int height = s.getHeight();
		//get the width of the phone
		int width=s.getWidth();
		
	//get the height and widht of the phone in the middle
		int x = width/2;
		int starty=(int)(height*0.8);
		int endy=(int)(width*0.2);
		
		TouchAction t=new TouchAction(driver);
		t.press(PointOption.point(x,starty))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
		.moveTo(PointOption.point(x,endy)).release().perform();
		
		
		
	}

}
