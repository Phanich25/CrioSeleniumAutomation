package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IMDbRatings {
     ChromeDriver driver;
    public IMDbRatings()
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
        // Navigate to url: "https://www.imdb.com/chart/top/" 
        driver.get("https://www.imdb.com/chart/top/");
        Thread.sleep(3000); 
        //Select object for the sort dropdown
        Select sortDropdown = new Select(driver.findElement(By.id("sort-by-selector")));
        // Select "ImDb rating" from the "Sort by" dropdown Using Locator "ID" "sort-by-selector" | Select | byVisbileText("IMDb rating")
        sortDropdown.selectByVisibleText("IMDb rating");
        // Find the highest rated movie Using Locator "XPath" "sort-by-selector" | Select | byVisbileText("IMDb rating")
        System.out.println(driver.findElement(By.xpath("//li[contains(@class,'ipc-metadata-list-summary-item')][1]//h3[@class='ipc-title__text'] ")).getText());
        Thread.sleep(5000);
        // Count the number of movies included in the table. Using Locator "XPath" //div[contains(@class,'cli-children')]//h3[@class='ipc-title__text'] | size()
        System.out.println(driver.findElements(By.xpath("//div[contains(@class,'cli-children')]//h3[@class='ipc-title__text']")).size());
        // Select "Release date" from the "Sort by" dropdown Using Locator "ID" "sort-by-selector" | Select | byVisbileText("Release date)
        sortDropdown.selectByVisibleText("Release date");
        // Click on the "swap sort order" button Using Locator "ID" "swap-sort-order-button" | click()
        driver.findElement(By.id("swap-sort-order-button")).click();
        // Find the oldest movie Using Locator "XPath" //li[contains(@class,'ipc-metadata-list-summary-item')][1]//[@class='ipc-title__text'] | getText()
        System.out.println(driver.findElement(By.xpath("//li[contains(@class,'ipc-metadata-list-summary-item')][1]//h3[@class='ipc-title__text'] ")).getText());
        // Click on the "swap sort order" button Using Locator "ID" "swap-sort-order-button" | click()
        driver.findElement(By.id("swap-sort-order-button")).click();
        // Find the newest movie Using Locator "XPath" //li[contains(@class,'ipc-metadata-list-summary-item')][1]//[@class='ipc-title__text'] | getText()
        System.out.println(driver.findElement(By.xpath("//li[contains(@class,'ipc-metadata-list-summary-item')][1]//h3[@class='ipc-title__text'] ")).getText());
        // Select "Number of ratings" from the "Sort by" dropdown Using Locator "ID" "sort-by-selector" | Select | byVisbileText("Number of ratings")
        sortDropdown.selectByVisibleText("Number of ratings");
        // Find the movie which has the most user ratings Using Locator "XPath" //li[contains(@class,'ipc-metadata-list-summary-item')][1]//[@class='ipc-title__text'] | getText()
        System.out.println(driver.findElement(By.xpath("//li[contains(@class,'ipc-metadata-list-summary-item')][1]//h3[@class='ipc-title__text'] ")).getText());
        System.out.println("end Test case: testCase01");
    }


    
}
