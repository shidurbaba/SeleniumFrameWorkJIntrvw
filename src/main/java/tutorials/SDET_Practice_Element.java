package tutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class SDET_Practice_Element {
    private WebDriver driver;
    public final String RADIO_LABEL = "Radio Button Examples";


    public SDET_Practice_Element(WebDriver driver) {
        this.driver = driver;
    }

    private enum Elements {
        RADIO_BUTTON_EXAMPLE_LABEL(By.xpath("//div[@id='radio-btn-example']/fieldset/legend[1]")),
        WEBTABLE_EXAMPLE(By.xpath("//tr/th")),
        WEBTABLE_COURSE(By.xpath("//tr/td[2]"));
        private By locator;

        private Elements(By locator) {
            this.locator = locator;
        }

    }


    public void getValidateRadioLabel() {
        String actualLabel = driver.findElement(Elements.RADIO_BUTTON_EXAMPLE_LABEL.locator).getText();
        try {
            Assert.assertEquals(RADIO_LABEL, actualLabel);
        } catch (Exception e) {
            e.printStackTrace();
            driver.close();
        }
    }

    public void sortAssertWebTableElement() {
        // Java 8 Streams -->
        List<WebElement> elementLists = driver.findElements(Elements.WEBTABLE_EXAMPLE.locator);
        System.out.println("Storing unsorted list in originaList");
        List<String> originalLists = elementLists.stream().map(s -> s.getText()).collect(Collectors.toList());
        System.out.println("Storing sorted list in newList");
        List<String> newList = originalLists.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(originalLists.equals(newList));

    }

/*    public void expectedCourse(String input)
    {
        // Java 8 Streams -->
        String expectedCourse = input;
        List<WebElement> listOfElements = driver.findElements(Elements.WEBTABLE_COURSE.locator);
        List<String>actualCourse= listOfElements.stream().filter(course -> course.getText().equalsIgnoreCase(expectedCourse)).
                map(course-> course.getText().toString()).collect(Collectors.toList());
        String actualResult = actualCourse.toString();
        System.out.println("Actual Course:" +actualResult);

        boolean flag=actualCourse.stream().anyMatch(s -> s.equalsIgnoreCase(expectedCourse));
        Assert.assertTrue(flag);
    }*/

    public void expectedCourse(String input) {
        String expectedCourse = input;
        String actualCourse = getExpectedCourse(input);
        System.out.println("Expected Course:" + expectedCourse);
        System.out.println("Actual Course:" + actualCourse);
    }

    public String getExpectedCourse(String input) {
        List<WebElement> listOfElements = driver.findElements(Elements.WEBTABLE_COURSE.locator);
         WebElement e = listOfElements.stream().filter(s-> s.getText().contains(input))
                 .findFirst().orElseThrow(() ->
            new RuntimeException("Nothing found")
        );
         String actual = e.getText();
         return actual;
    }

}