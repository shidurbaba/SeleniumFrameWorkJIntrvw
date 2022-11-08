package chromeheadless_testng_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import tutorials.GuruPracticePage;

import java.util.concurrent.TimeUnit;

public class AutomationPracticePage_Rahul {

    public static void main (String []args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        //ChromeOptions headlessoptions = new ChromeOptions();
        /*headlessoptions.addArguments("windows-size=1400,1800");
        headlessoptions.addArguments("headless");*/


        //WebDriver driver = new ChromeDriver(headlessoptions);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://demo.guru99.com/");

        GuruPracticePage test_one = new GuruPracticePage(driver);
        test_one.validateHeaderTitle();
       //Thread.sleep(3000);

        test_one.sendTextToEmailField("Hello There");
        Thread.sleep(1000);

        test_one.selectSeleniumOptionsDropDown("Flash");
        Thread.sleep(1000);
        driver.close();

    }


}




