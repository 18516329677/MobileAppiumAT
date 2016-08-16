package cn.com.APPIUM.Testing.MobileAT.testcase;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class startAppiumLocalService {

	String service_url;
	private AppiumDriver<?> driver;

	@BeforeTest

	public void setUp() throws Exception {

		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("/Applications/Appium.app/Contents/Resources/node/bin/node"))
				.withAppiumJS(
						new File("/Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/main.js"))
				.usingAnyFreePort());
		service.start();
		service_url = service.getUrl().toString();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "ios");
		capabilities.setCapability("deviceName", "iPhone 5");
		capabilities.setCapability("platformVersion", "9.3");
		capabilities.setCapability("No Reset", "true");
        //capabilities.setCapability("ipa", "/Users/chenpenn/Desktop/KaKa_iOS.ipa");

		//capabilities.setCapability("udid", "09d0051562ad9a0398fcbd94de68a719a8153689");
		capabilities.setCapability("bundleId", "com.opentrans.kaka");
		driver = new IOSDriver(new URL(service_url), capabilities);

	}

	@Test
	public void testfindElementByIosUIAutomation() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(MobileBy.IosUIAutomation(".navigationBars()[0].buttons().withPredicate(\"name == 'search'\")")).click();
		driver.findElement(MobileBy.IosUIAutomation(".navigationBars()[0].buttons().withPredicate(\"name == 'Back'\")")).click();
		driver.findElement(MobileBy.IosUIAutomation(".navigationBars()[0].buttons().withPredicate(\"name == 'search'\")")).click();
		driver.findElement(MobileBy.IosUIAutomation(".navigationBars()[0].buttons().withPredicate(\"name == 'Back'\")")).click();
		driver.findElement(MobileBy.IosUIAutomation(".navigationBars()[0].buttons().withPredicate(\"name == 'search'\")")).click();
		driver.findElement(MobileBy.IosUIAutomation(".navigationBars()[0].buttons().withPredicate(\"name == 'Back'\")")).click();
/*
		driver.findElement(By.xpath("//UIAButton[contains(@name,'search')]")).click();
		driver.findElement(By.xpath("//UIAButton[contains(@name,'Back')]")).click();
		driver.findElement(By.xpath("//UIAButton[contains(@name,'search')]")).click();
		driver.findElement(By.xpath("//UIAButton[contains(@name,'Back')]")).click();
		driver.findElement(By.xpath("//UIAButton[contains(@name,'search')]")).click();
		driver.findElement(By.xpath("//UIAButton[contains(@name,'Back')]")).click();
				*/

		//UIAButton[contains(@name,'Back')]
		//UIAButton[contains(@name,'search')]
		//51148ms
		//60661ms 22.377s 59620ms 22.482s 136170ms 22.386

	}
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
}
