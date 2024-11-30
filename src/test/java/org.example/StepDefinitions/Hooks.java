package org.example.StepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

public class Hooks {
    public static WebDriver driver;
// this page to load driver instead of load every time now just call
    @Before
    public void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");        // Disable extensions
        options.addArguments("--disable-gpu");              // Disable GPU acceleration
        options.addArguments("--no-sandbox");               // Disable sandbox
        options.addArguments("--disable-dev-shm-usage");    // Overcome limited resource problems
        options.addArguments("--disable-notifications");     // Disable notifications
        options.addArguments("--start-maximized");          // Start maximized
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));//this time to write verify chars manually
        driver.get("https://ecommerce.tealiumdemo.com/");
    }

    @After
    public void tearDown() throws InterruptedException {

    }
}
