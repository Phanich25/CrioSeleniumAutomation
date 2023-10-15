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


public class BookMyShowCountRecommendations {
    ChromeDriver driver;
    public BookMyShowCountRecommendations()
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
        //Navigate to url "www.bookmyshow.com"  
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(5000);
        
        /*Print the image urls of all recommended movies Using Locator "XPath" //h2[text()='Recommended Movies']/parent::div/parent::div/parent::div/following-sibling::div//img
        | findElements | List | size() | get(i).getAttribute('src')*/
        List<WebElement> imageURLList = driver.findElements(By.xpath("//h2[text()='Recommended Movies']/parent::div/parent::div/parent::div/following-sibling::div//img"));
        int len = imageURLList.size();
        for(int i=0;i<len;i++)
        {
            System.out.println(imageURLList.get(i).getAttribute("src"));
        }
        Thread.sleep(20000);
       // Print the title and language of the second item from the premiers Using Locator "XPath" //h2[text()='Premieres']/parent::div/parent::div/parent::div/following-sibling::div/div/div/a[2]/div/div[3]/div/div | findElements | List | size() | get(1).getText() and get(2).getText()
        WebElement titleForSecondIteminPremier = driver.findElement(By.xpath("//h2[text()='Premieres']/parent::div/parent::div/parent::div/following-sibling::div/div/div/a[2]/div/div[3]/div[1]/div"));
        System.out.println(titleForSecondIteminPremier.getText());
        WebElement languageOfSecondIteminPremier = driver.findElement(By.xpath("//h2[text()='Premieres']/parent::div/parent::div/parent::div/following-sibling::div/div/div/a[2]/div/div[3]/div[2]/div"));
        System.out.println(languageOfSecondIteminPremier.getText());
        ////h2[text()='Premieres']/parent::div/parent::div/parent::div/following-sibling::div/div/div/a[2]/div/div[3]/div/div
       
        System.out.println("end Test case: testCase01");
    }


}
