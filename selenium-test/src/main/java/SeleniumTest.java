import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.StdoutLogHandler;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;

import shared.SayHello;

public class SeleniumTest {
	
	public void runSeleniumTest() {
		EyesRunner runner = new ClassicRunner();
		Eyes eyes = new Eyes(runner); 
		eyes.setLogHandler(new StdoutLogHandler());
		eyes.setApiKey(System.getenv("APPLITOOLS_API_KEY"));
		WebDriver driver = new ChromeDriver();
		try {
			eyes.open(driver, "Selenium Test", "Test", new RectangleSize(1200, 700)); 
			driver.get("https://applitools.com");
			eyes.check("TAG NAME", Target.window());
			eyes.closeAsync();
		} finally {
			driver.close();
			eyes.abort();
		}
	}
	
	public void sayHello() {
		SayHello hello = new SayHello("From Selenium"); 
		hello.printGreeting();
	}
}