package demo;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {
    ChromeDriver driver;
    public WindowHandles()
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

    
    public  void testCase01() throws Exception{
        System.out.println("Start Test case: testCase01");
        
        // Navigate to url: "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open"  
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        //Thread.sleep(10000);
        // It will return the parent window name as a String
        String parent=driver.getWindowHandle();
        driver.switchTo().frame("iframeResult");
        // Click on "Try it" button Using Locator "XPath" //button[text()='Try it'] | click()
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        Set<String>s=driver.getWindowHandles();

        // Now iterate using Iterator
        Iterator<String> I1= s.iterator();

        while(I1.hasNext())
        {

        String child_window=I1.next();


        if(!parent.equals(child_window))
        {
        // Switch to new page      
        driver.switchTo().window(child_window);
        // Get the URL using driver.getURL() 
        System.out.println(driver.getCurrentUrl());
        // Get the title using driver.getTitle() 
        //System.out.println(driver.switchTo().window(child_window).getTitle());
        System.out.println(driver.getTitle());
        // Take screenshot using Screenshot class object. 
        takeSnapShot(driver, "C:\\Users\\00516C744\\Documents\\SeleniumCrioAutomation\\Snapshots\\WindowHandlesTest.png");
        // Close the window using driver.close() 
        driver.close();
        }

        }
       // Switch to the parent window  using driver.switchTo().window(parentWindow) 
        driver.switchTo().window(parent);
        System.out.println("end Test case: testCase01");

        }
        
         
       public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
            //Convert web driver object to TakeScreenshot
            TakesScreenshot scrShot =((TakesScreenshot)webdriver);
            //Call getScreenshotAs method to create image file
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            //Move image file to new destination
            File DestFile=new File(fileWithPath);
            //Copy file at destination
            FileUtils.copyFile(SrcFile, DestFile);
            }
    

}
