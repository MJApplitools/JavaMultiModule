
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.applitools.eyes.appium.Eyes;
import com.applitools.eyes.appium.Target;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import shared.SayHello;

public class AppiumTest {
	public void runAppiumTest() throws MalformedURLException {
		  Eyes eyes = new Eyes();
		  System.out.println("test");

		  eyes.setApiKey(System.getenv("APPLITOOLS_API_KEY"));
		  eyes.setForceFullPageScreenshot(true);
		
		  DesiredCapabilities dc = new DesiredCapabilities();
		  
		  dc.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.3.4");
		  dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.1");
		  dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		  dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		  dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
		  dc.setCapability(MobileCapabilityType.APP, "/Users/mattjasaitis/Desktop/Tools/test-apps/iOSTestApp.zip");
		  
		  IOSDriver<WebElement> driver = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc); 
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		  try {
			  eyes.open(driver, "iOS test application", "test");
			  eyes.check(Target.window());
		      eyes.close();
		  } finally {
		      eyes.abortIfNotClosed();
		      driver.quit();
		  }
	}
	
	public void sayHello() {
		SayHello hello = new SayHello("From Appium"); 
		hello.printGreeting();
	}
	
}
