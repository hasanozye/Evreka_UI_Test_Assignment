import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import utilities.TestBase;

public class amazonTest extends TestBase {

    //TODO
    // We expect you to automate the following steps via Selenium Web Driver, regardless of
    //    checking for expected/actual results. We prefer Chrome as the browser, but the choice
    //    is yours.
    //    Notes: It may also be necessary to write code to accept the accept cookies warning.
    //            1. Go to 'https://www.amazon.com.tr/'
    //            2. Search iPhone13 512
    //            3. Check that the results are listed
    // 4. Click iPhone13 at the top of the list
    // 5. Log the following values for each size
    // .Size information .Price .Color .Stock status*/

    @Test
    public void test01() {
        // TODO: First i create an action class to interact with WebElements.
        Actions actions = new Actions(driver);

        // TODO: 1. Go to 'https://www.amazon.com.tr/'
        driver.get("https://www.amazon.com.tr/");

        // TODO: Cookie pops-up so i have to handle that first.
        WebElement acceptCookie = driver.findElement(By.xpath("(//input[@type=\"submit\"])[1]"));
        actions.click(acceptCookie).
                perform();

        // TODO: 2. Search iPhone13 512
        WebElement searchBar = driver.findElement(By.id("nav-search-bar-form"));
        actions.click(searchBar).
                sendKeys("iPhone13 512", Keys.ENTER).
                perform();


        // TODO: 3. Check that the results are listed
        WebElement resultsListed = driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        String listedText = resultsListed.getText();
        assertTrue(listedText.contains("iphone 13 512"));

        //TODO 4. Click iPhone13 at the top of the list
        WebElement firstIphone = driver.findElement(By.xpath("(//div[@class=\"a-section a-spacing-base\"])[1]"));

        //first i'll scroll to element to prevent any defect from user's computer screen size
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)", firstIphone);

        actions.click(firstIphone).perform();

        //TODO 5. Log the following values for each size
        //    // .Size information .Price .Color .Stock status*/

        //Size
        WebElement size = driver.findElement(By.xpath("(//span[@class=\"selection\"])[1]"));
        String sizeText = size.getText();
        System.out.println("Size = " + sizeText);

        //Color
        WebElement zegmaBlue = driver.findElement(By.xpath("(//span[@class=\"selection\"])[2]"));
        String zegmaBlueText = zegmaBlue.getText();
        System.out.println("Color = " + zegmaBlueText);

        //Price
        WebElement price = driver.findElement(By.xpath("(//span[@class=\"a-price-whole\"])[1]"));
        String priceText = price.getText();
        System.out.print("Price = " + priceText);

        //exact Price
        WebElement pricePenny = driver.findElement(By.xpath("(//span[@class=\"a-price-fraction\"])[1]"));
        String pricePennyText = pricePenny.getText();
        System.out.println("," + pricePennyText + "TL");

        //stock
        WebElement stock = driver.findElement(By.xpath("//span[@class=\"a-size-medium a-color-success\"]"));
        String stockText = stock.getText();
        System.out.println("Stock = " + stockText);


    }


}
