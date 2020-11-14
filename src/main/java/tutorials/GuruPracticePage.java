package tutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class GuruPracticePage
{
    private WebDriver driver;
    private final String Expected_Title_Header_Text = "Demo Site";

    public GuruPracticePage(WebDriver driver)
    {
        this.driver = driver;
    }

    private enum Elements {
        DEMO_SITE_HEADER(By.xpath("//a[text()='Demo Site']")),
        EMAIL_ID_INPUTFIELD(By.xpath("//input[@name='emailid']")),
        SELENIUM_DROPDOWN(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a")),
        SELENIUM_DROPDOWN_OPTIONS(By.xpath("//ul/li[1]/ul/li"));
        private By locator;
        private Elements(By locator) {
            this.locator = locator;
        }

    }

    public void validateHeaderTitle() {
        String actualLabel = driver.findElement(Elements.DEMO_SITE_HEADER.locator).getText();
        try {
            System.out.println("Actual Label:" + actualLabel);
            System.out.println("Expected label:" + Expected_Title_Header_Text);
            Assert.assertEquals(Expected_Title_Header_Text, actualLabel);
        } catch (Exception e) {
            e.printStackTrace();
            driver.close();
        }
    }

    public void sendTextToEmailField(String arg)
    {
        String sText = arg.trim();
        try
        {
            driver.findElement((Elements.EMAIL_ID_INPUTFIELD.locator)).sendKeys(sText);

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void selectSeleniumOptionsDropDown(String arg)
    {
        try
        {
            driver.findElement((Elements.SELENIUM_DROPDOWN.locator)).click();
            List<WebElement> seleniumoptions =  driver.findElements((Elements.SELENIUM_DROPDOWN_OPTIONS.locator));
            int options = seleniumoptions.size();

            for(int i =0; i <options; i++)
            {
                seleniumoptions.get(i).getText().contains(arg);
                seleniumoptions.get(i).click();
            }


        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

}
