package chromeheadless_testng_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tutorials.SDET_Practice_Element;

import java.util.concurrent.TimeUnit;

public class HeadlessDriverTest {
    private WebDriver driver;
    private ChromeOptions options;


    @BeforeTest
    public void setupTest()
    {
        //ChromeDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","src/main/drivers/chromedriver.exe");
        options = new ChromeOptions();
       // options.addArguments("headless");
     //   options.addArguments("no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

 /*   @Test(priority = 1)
    public void testHeadLessChrome()
    {
        driver.get("https://learn.letskodeit.com/p/practice");
        String title = driver.getTitle();
        System.out.println(title);

        SDET_Practice_Element practice_element = new SDET_Practice_Element(driver);

        practice_element.getValidateRadioLabel();
    }

    @Test(priority = 2)
    public void testSortedTable(){
        driver.get("https://learn.letskodeit.com/p/practice");
        String title = driver.getTitle();
        System.out.println(title);

        SDET_Practice_Element practice_element = new SDET_Practice_Element(driver);
        practice_element.sortAssertWebTableElement();
    }*/
    @Test(priority = 1)
    public void testExpectedCourses(){
        driver.get("https://learn.letskodeit.com/p/practice");
        String title = driver.getTitle();
        System.out.println(title);

        SDET_Practice_Element practice_element = new SDET_Practice_Element(driver);
        practice_element.expectedCourse("Selenium WebDriver With Java");
    }



}
