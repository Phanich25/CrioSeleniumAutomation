package demo;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PostImageLinkedin {
    ChromeDriver driver;
    public PostImageLinkedin()
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
        //Navigate to linkedin page
        driver.get("https://in.linkedin.com/");
        Thread.sleep(3000);
        // Click on "Sign in" link Using Locator "Partial Link Text" Sign in | click()
        driver.findElement(By.partialLinkText("Sign in")).click();
        Thread.sleep(3000);
        // In the "Sign in" page, enter username Using Locator "ID" username | sendkeys("phanikumar")
        driver.findElement(By.id("username")).sendKeys("phani.cherukuri@gmail.com");
        Thread.sleep(3000);
        // In the "Sign in" page, enter password Using Locator "ID" password | sendkeys("**************")
        driver.findElement(By.id("password")).sendKeys("******");
        Thread.sleep(3000);
        // Click on "Sign in" button Using Locator "XPath" //button[text()='Sign in'] | click()
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        Thread.sleep(3000);
        // Click on Start a post Using Locator "XPath" //button//span[text()='Start a post'] | click()
        driver.findElement(By.xpath("//span[text()='Start a post']"));
        Thread.sleep(3000);
        // Click on Add Media icon Using Locator "XPath" //button[@aria-label='Add media'] | click()
        driver.findElement(By.xpath("//button[@aria-label='Add media']")).click();
        Thread.sleep(3000);
        //Get the path of the file
        Path path = Paths.get("src/resources/selenium-snapshot.png");
        //Create a file
        //File imagePath = new File(path.toUri());
        //Upload the file using sendkeys option for webelement: "Upload from computer"
        //driver.findElement(By.xpath("//label[text()='Upload from computer']")).sendKeys("C:\\Users\\00516C744\\Desktop\\Phani_Photo.jpeg");
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\00516C744\\Desktop\\Phani_Photo.jpeg");
        Thread.sleep(3000);
        //Click on the Next button.
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(3000);
        //Click on the Post button.
        driver.findElement(By.xpath("//span[text()='Post']")).click();
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
