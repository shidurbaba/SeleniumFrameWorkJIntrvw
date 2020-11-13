package tutorials;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public static WebDriver driver;
    public static Iterator it;
    public static JavascriptExecutor javascriptExecutor;
    public static Select select;
    public static Actions actions;
    public static SoftAssert softAssert;

    public WebDriver initialize(String browserType) {
        String lowerCaseBrowserType = browserType.toLowerCase().trim();
        if (lowerCaseBrowserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            javascriptExecutor = (JavascriptExecutor)driver;
            actions = new Actions(driver);
            softAssert = new SoftAssert();
            step2initialize(driver);
        } else if (lowerCaseBrowserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            step2initialize(driver);
        } else if (lowerCaseBrowserType.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            step2initialize(driver);
        }
        return driver;
    }

    public static void sleep(long number)
    {
        try {
            Thread.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollToView(WebElement element)
    {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
        sleep(1000);
    }
    /*Select dropdown action using Select*/
    public void selectDropDownAction(WebElement element, String enterValue)
    {
        select = new Select(element);
        select.selectByVisibleText(enterValue);
    }

    /*Select dropdown using withoutSelect*/

    public void selectDropDownAction(String xpath, String menuvalue)
    {
        List<WebElement> menu = driver.findElements(By.xpath(xpath));
         for(int i = 0; i<menu.size(); i++)
         {
             WebElement element  = menu.get(i);
             String menuString = element.getText();
             System.out.println("Printing Strings_Of_Value : " + menuString );
             if(menuString.contentEquals(menuvalue))
             {
                 element.click();
                 break;
             }
         }


    }








    public void maximize(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public void pageloadOut(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    }

    public void implicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    public void step2initialize(WebDriver driver) {
        maximize(driver);
        pageloadOut(driver);
        implicitWait(driver);
    }

    public void clickRadioButton(WebElement webElement) {
        boolean value = webElement.isSelected();
        if (value == true) {
            driver.switchTo().activeElement();
            System.out.println("WebElement " + webElement + " was selected.");
        } else {
            webElement.click();
        }
    }

    public void switchToNewWindow() {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String mainWindow = it.next();
        String newWindow = it.next();
        driver.switchTo().window(newWindow);
        driver.manage().window().maximize();

    }

    public void switchToMainWindow() {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String mainWindow = it.next();
        driver.switchTo().window(mainWindow);

    }

    public void IsVisible(WebElement element) {
        boolean value = element.isDisplayed();
        Assert.assertTrue(value);
    }

    public void clickOnRadioButton(WebElement element) {
        List<WebElement> listofElement = new ArrayList<WebElement>();
        boolean isPresent = listofElement.add(element);
        if (isPresent) {
            for (int i = 0; i < listofElement.size(); i++) {
                if (listofElement.get(i).isSelected()) {
                    System.out.println("The Radio Button is selected ");
                } else if (!listofElement.get(i).isSelected()) {
                    listofElement.get(i).click();
                }
            }
        }
    }
    // Validate all the values in the dropdown are in order
    // It should return me true or false

    public boolean checkDropDownValueOrderList(WebElement element) {
        List<WebElement> dropDownElements = new ArrayList<WebElement>();
        boolean checkValuePresent = dropDownElements.add(element);
        boolean returnValue = false;
        if (checkValuePresent) {
            for (int i = 0; i < dropDownElements.size(); i++) {
                String dropDownElmentsToString = dropDownElements.get(i).getText();
                if (dropDownElmentsToString.equalsIgnoreCase(CommonInstances.CAR_CLASS[i])) {
                    returnValue = true;
                }else{
                    returnValue = false;
                }
            }
        }
        return returnValue;
    }
    public void clickIfVisible(WebElement element){
        List<WebElement> list = new ArrayList<WebElement>();
        list.add(element);
        String elements = "";
        for(int i = 0 ; i < list.size(); i++){
            elements = list.get(i).toString();
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(CommonInstances.CLICKBUTTON, driver.findElement(By.xpath(elements)));
    }

    public void selectFromDropDownMenu(WebElement element, String dropDownValue) throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.click(element).build().perform();
        actions.sendKeys(element, dropDownValue).build().perform();
        actions.click();
        Thread.sleep(2000);

    }

    public void clickAndHold(WebElement element) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).clickAndHold(element).click().build().perform();
    }

    public WebElement getElementSafely(By locator){
        WebElement elementToReturn = driver.findElement(By.xpath(locator.toString()));
        return elementToReturn;
    }



}




