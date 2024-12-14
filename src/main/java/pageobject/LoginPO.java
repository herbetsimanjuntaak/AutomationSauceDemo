package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;


public class LoginPO {

    WebDriver driver;
    SeleniumHelpers selenium;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
        this.selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     *
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css,
     * className, xpath as attributes.
     */

    @FindBy(name = "user-name")
    private WebElement usernameEditText;

    @FindBy(name = "password")
    private WebElement passwordEditText;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement loginMessageError;


    /**
     * Enters the provided username into the username input field.
     *
     * @param username The username to be entered into the input field.
     */
    public void enterUsername(String username) {
        selenium.enterText(usernameEditText, username, true);
    }

    /**
     * Enters the provided password into the password input field.
     *
     * @param password The password to be entered into the input field.
     */
    public void enterPassword(String password) {
        selenium.enterText(passwordEditText, password, true);
    }

    /**
     * Clicks on the login button to initiate the login process.
     *
     * @throws InterruptedException If the thread is interrupted during the click operation.
     */
    public void clickOnLoginButton() throws InterruptedException {
        selenium.clickOn(loginButton);
    }

    /**
     * Retrieves the error message displayed on the login page when login fails.
     *
     * @return The error message text displayed on the page.
     */
    public String getLoginMessageError() {
        return selenium.getText(loginMessageError);
    }


    /**
     * Verifies if the login form, specifically the login button, is visible in the viewport.
     *
     * @return true if the login button is visible, false otherwise.
     */
    public Boolean displayFromLogin() {
        return selenium.isVisibleInViewport(loginButton);
    }

}
