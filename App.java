/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws Exception {
        //TestCases tests = new TestCases(); // Initialize your test class
        //SearchAmazon searchAmazon = new SearchAmazon();
        //BookMyShowCountHyperlinks countHyperlinks = new BookMyShowCountHyperlinks();
        //PostInLinkedin postInLinkedin = new PostInLinkedin();
        //BookMyShowCountRecommendations countRecommendations = new BookMyShowCountRecommendations();
        //PostImageLinkedin postImageLinkedin = new PostImageLinkedin();
        //NestedFrames nestedFrames = new NestedFrames();
        //IMDbRatings imDbRatings = new IMDbRatings();
        WindowHandles windowHandles = new WindowHandles();

        //TODO: call your test case functions one after other here

        //tests.testCase01();
        //searchAmazon.testCase01();
        //countHyperlinks.testCase01();
        //postInLinkedin.testCase01();
        //countRecommendations.testCase01();
        //postImageLinkedin.testCase01();
        //nestedFrames.testCase01();
        //imDbRatings.testCase01();
        windowHandles.testCase01();
        //END Tests

        //tests.endTest();
        //searchAmazon.endTest(); // End your test by clearing connections and closing browser
        //countHyperlinks.endTest();
        //postInLinkedin.endTest();
        //countRecommendations.endTest();
        //postImageLinkedin.endTest();
        //nestedFrames.endTest();
        //imDbRatings.endTest();
        windowHandles.endTest();
        
    }

    public static void main(String[] args) throws Exception {
        new App().getGreeting();
    }
}