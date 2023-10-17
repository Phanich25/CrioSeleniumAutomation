package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames {
     ChromeDriver driver;
    public NestedFrames()
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
        //Navigate to url: "https://the-internet.herokuapp.com/nested_frames"
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        //Switch to frame "frame-top"
        driver.switchTo().frame("frame-top");
        Thread.sleep(3000);
        // Switch to frame "frame-left" Using Locator "Name" "frame-left"
        driver.switchTo().frame("frame-left");
        // Select the body and find the text Using Locator "XPath" //body[contains(text(),'LEFT')] | getText()
        System.out.println(driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText());
        // Swith to parent frame: "frame-top"  
        driver.switchTo().parentFrame();
        // Switch to frame "frame-middle" Using Locator "Name" "frame-middle"
        driver.switchTo().frame("frame-middle");
        // Select the body and find the text Using Locator "XPath" //body[contains(text(),'MIDDLE')] | getText()
        System.out.println(driver.findElement(By.id("content")).getText());
        // Swith to parent frame: "frame-top"  driver.switchTo().parentFrame()
        driver.switchTo().parentFrame();
        // Switch to frame "frame-right" Using Locator "Name" "frame-right"
        driver.switchTo().frame("frame-right");
        // Select the body and find the text Using Locator "XPath" //body[contains(text(),'RIGHT')] | getText()
        System.out.println(driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText());
        // Swith to default content .  driver.switchTo().defaultContent()
        driver.switchTo().defaultContent();
        // Switch to frame "frame-bottom" Using Locator "Name" "frame-bottom"
        driver.switchTo().frame("frame-bottom");
        // Select the body and find the text Using Locator "XPath" //body[contains(text(),'BOTTOM')] | getText()
        System.out.println(driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText());
        // Swith to default content .  driver.switchTo().defaultContent()
        driver.switchTo().defaultContent();
        System.out.println("end Test case: testCase01");
    }
}
