import enums.DriversPaths;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SeleniumTag {
    WebDriver driver;
    DesiredCapabilities caps;
    public final String USERNAME = "yoni27";
    public final String AUTOMATE_KEY = "nrA3qNRqvEHGyEow7LjD";
    public final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    private String tagUrl = "http://atidcollege.co.il/selenium-tag/";

    @Before
    public void openBrowser() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "70.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "7");
        caps.setCapability("resolution", "1920x1080");
        driver = new RemoteWebDriver(new URL(URL), caps);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(tagUrl);
    }

    @After
    public void closeBrowser() throws InterruptedException {
        System.out.println("closing browser");
        Thread.sleep(10000);
        driver.quit();
    }


//    LOCAL RUN BEFORE
//    @Before
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", DriversPaths.Chrome.getPath());
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get(tagUrl);
//        System.out.println("Opened browser in url: " + tagUrl);
//    }

    @Test
    public void test1() {
        System.out.println("Typing \"Alon Hartman\"");
        driver.findElement(By.id("myName")).sendKeys("Alon Hartman");
        System.out.println("clicking on submit button");
        driver.findElement(By.id("submit")).click();
        System.out.println("double clicking on the second button");
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.id("myButton"));
        action.doubleClick(element).perform();

    }
}


