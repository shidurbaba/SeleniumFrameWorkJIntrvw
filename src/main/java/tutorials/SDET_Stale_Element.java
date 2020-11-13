package tutorials;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SDET_Stale_Element{

    public static void main (String []args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions headlessoptions = new ChromeOptions();
        headlessoptions.addArguments("windows-size=1400,1800");
        headlessoptions.addArguments("headless");


        WebDriver driver = new ChromeDriver(headlessoptions);
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);


        driver.get("https://learn.letskodeit.com/p/practice");

        SDET_Practice_Element practice_element = new SDET_Practice_Element(driver);

        practice_element.getValidateRadioLabel();

    }


}




