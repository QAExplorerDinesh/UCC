package com.ucc.MobileAppTesting;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumBy.ByAccessibilityId;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@Test
	public void configureAppium() throws MalformedURLException {

		// Run appium Server Automatically
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\conne\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(130)).build();

		service.start();

		// Create Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("DINESH");
		options.setApp(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\ApiDemos-debug.apk");

		// Create object for AndroidDriver/iOS Driver

		@SuppressWarnings("deprecation")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
		// driver.findElement(AppiumBy.accessibilityId("Preference")).click();)

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Preferences from XML\"]")).click();
		
		driver.findElement(By.xpath("(//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"])[1]")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit text preference\"]")).click();
	
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/edit\"]")).sendKeys("Lhasapso");
		
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		//driver.quit();
		//service.stop();

		// Object Locators: xpath,id,className,accessibilityId,androidUIautomater

	}

}
