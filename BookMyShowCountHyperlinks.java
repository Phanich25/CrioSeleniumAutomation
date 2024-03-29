package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class BookMyShowCountHyperlinks {
    ChromeDriver driver;
    public BookMyShowCountHyperlinks()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");

        // Navigate to "www.bookmyshow.com"  
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(3000);
        // Get the count of hyperlinks Using Locator "XPath" //a[@href] / size()
        // Print the count of hyperlinks  
        System.out.println("The total number of hyper links are : " + driver.findElements(By.xpath("//a[@href]")).size());
        System.out.println("end Test case: testCase01");
    }


}
