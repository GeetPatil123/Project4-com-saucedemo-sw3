package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";//Browser URL

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }//Opening the browser

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.id("user-name"), "standard_user");//Passing the username into username field
        sendTextToElement(By.id("password"), "secret_sauce");//Passing the password into password field
        clickOnElement(By.id("login-button"));//Clicking the Login Button
        isTextDisplayed(By.className("title"),"Products");//Verifying the Text Products
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        sendTextToElement(By.id("user-name"), "standard_user");//Passing the username into username field
        sendTextToElement(By.id("password"), "secret_sauce");//Passing the password into password field
        clickOnElement(By.id("login-button"));//Clicking the Login Button
        getNumberFromElement(By.className("inventory_item"),6);//Verifying the 6 Products are displayed
    }
    @After
    public void tearDown() {
        closeBrowser();
    }//Closing all the Browser instance
}
