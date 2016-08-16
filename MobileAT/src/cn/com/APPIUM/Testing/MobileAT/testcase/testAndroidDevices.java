package cn.com.APPIUM.Testing.MobileAT.testcase;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testAndroidDevices {

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
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Genymotion");
		capabilities.setCapability("platformVersion", "5.1");
		capabilities.setCapability("app", "/Users/chenpenn/Desktop/otms_kaka_driver.apk");

		//capabilities.setCapability("udid", "09d0051562ad9a0398fcbd94de68a719a8153689");
		capabilities.setCapability("appPackage", "com.opentrans.driver");
		capabilities.setCapability("appActivity", ".ui.login.WelcomeActivity");
		capabilities.setCapability("appWaitActivity", ".ui.MainActivity");
		//capabilities.setCapability("appPackage", "com.opentrans.driver");
		driver = new AndroidDriver(new URL(service_url), capabilities);

	}

	@Test
	public void testfindElementByIosUIAutomation() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
}
