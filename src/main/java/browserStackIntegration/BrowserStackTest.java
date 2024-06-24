package browserStackIntegration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserStackTest {
    public static final String USERNAME = "gajendrasaxena_drowfv";
    public static final String AUTOMATE_KEY = "BkdGWcfdpjxqzt8R7Neh";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void loadBrowser() throws MalformedURLException {
    	WebDriverManager.chromedriver().setup();
    	 DesiredCapabilities caps = new DesiredCapabilities();
         caps.setCapability("browserName", "Chrome");
         caps.setCapability("browserVersion", "124.0");
         
         Map<String, Object> browserstackOptions = new HashMap<String, Object>();
         browserstackOptions.put("os", "Linux");
         browserstackOptions.put("osVersion", "20.4");
        // browserstackOptions.put("sessionName", "My First Test"); 
         // Typically the key should be 'sessionName' instead of 'name'
         browserstackOptions.put("userName", USERNAME);
         browserstackOptions.put("accessKey", AUTOMATE_KEY);

         caps.setCapability("bstack:options", browserstackOptions);

         WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
         driver.get("http://www.google.com");
         System.out.println(driver.getTitle());
         driver.quit();
    }
}
