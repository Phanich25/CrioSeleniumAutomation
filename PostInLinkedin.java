package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
///
import org.openqa.selenium.support.ui.WebDriverWait;


public class PostInLinkedin {
    ChromeDriver driver;
    public PostInLinkedin()
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
        //Navigate to linkedin URL "https://in.linkedin.com/"
        driver.get("https://in.linkedin.com/");
        // Click on "Sign in" link Using Locator "Partial Link Text" Sign in | click()
        Thread.sleep(3000);
        driver.findElement((By.partialLinkText("Sign in"))).click();
        Thread.sleep(3000);
        // In the "Sign in" page, enter username Using Locator "ID" username | sendkeys("phanikumar")
        driver.findElement(By.id("username")).sendKeys("phani.cherukuri@gmail.com");
        Thread.sleep(3000);
        // In the "Sign in" page, enter password Using Locator "ID" password | sendkeys("**************")
        driver.findElement(By.id("password")).sendKeys("********");
        Thread.sleep(3000);
        // Click on "Sign in" button Using Locator "XPath" //button[text()='Sign in'] | click()
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        Thread.sleep(3000);
        // Get the count of people who viewed your profile Using Locator "XPath" //span[contains(text(),'viewed')]/ancestor::div/div/span/strong | gettext()
        System.out.println("Count of profile views: " + driver.findElement(By.xpath("//span[contains(text(),'viewed')]/ancestor::div/div/span/strong")).getText());
        Thread.sleep(3000);
        // Get the count of impressions of your post. Using Locator "XPath" //span[contains(text(),'Impressions')]/ancestor::div/div/span/strong | gettext()
        System.out.println("Count of post impressions: " + driver.findElement(By.xpath("//span[contains(text(),'Impressions')]/ancestor::div/div/span/strong")).getText());
        Thread.sleep(3000);
        // Click on Start a post Using Locator "XPath" //button//span[text()='Start a post'] | click()
        driver.findElement(By.xpath("//button//span[text()='Start a post']")).click();
        Thread.sleep(3000);
        // Click on the options to select to whom to be posted Using Locator "XPath" //span[contains(text(),'Phani')] | click()
        driver.findElement(By.xpath("//span[contains(text(),'Phani')]")).click();
        Thread.sleep(3000);
        // Select the option "CONNECTIONS_ONLY' Using Locator "ID" CONNECTIONS_ONLY | click()
        driver.findElement(By.id("CONNECTIONS_ONLY")).click();
        Thread.sleep(3000);
        // Click on the Done button. Using Locator "XPath" //button//span[text()='Done'] | click()
        driver.findElement(By.xpath("//button//span[text()='Done']")).click();
        Thread.sleep(3000);
        // Create a post Using Locator "XPath" //div[@role='textbox'] | sendkeys("hello")
        driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("hello");
        Thread.sleep(3000);
        // Click on post button. Using Locator "XPath" //button//span[text()='Post'] | click()
        driver.findElement(By.xpath("//button//span[text()='Post']")).click();
        Thread.sleep(3000);
        // Click on View Post alert. Using Locator "XPath" //a[text()='View post'] | click()
        driver.findElement(By.xpath("//a[text()='View post']")).click();
        Thread.sleep(3000);
        //
        List<WebElement> imgList = driver.findElements(By.xpath("//img[contains(@alt,'Phani')]"));
        imgList.get(0).click();
        //Declare and initialise a fluent wait
        //WebDriverWait wait = new WebDriverWait(driver,10);
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("a[href*='logout']")))).click();
        driver.findElement(By.cssSelector("a[href*='logout']")).click();
        Thread.sleep(3000);
        System.out.println("end Test case: testCase02");
    }


}
