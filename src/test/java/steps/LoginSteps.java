package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.LoginPO;
import pageobject.MenuPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class LoginSteps {

    private final WebDriver driver = ThreadManager.getDriver();
    private final SeleniumHelpers selenium = new SeleniumHelpers(driver);
    private final LoginPO login = new LoginPO(driver);
    private final MenuPO menu = new MenuPO(driver);


    @Given("users access page {string}")
    public void userAccessPage(String url) {
        selenium.navigateToPage(url);
    }

    @When("users input username {string}")
    public void userInputUsername(String username) {
        login.enterUsername(username);
    }

    @And("users input password {string}")
    public void userInputPassword(String password) {
        login.enterPassword(password);
    }

    @And("users click on login button")
    public void userClickOnLoginButton() throws InterruptedException {
        login.clickOnLoginButton();
    }

    @Then("users should see display burger menu")
    public void userShouldSeeDisplayBurgerMenu() {
        Assert.assertTrue(menu.displayBurgerMenu());
    }

    @Then("system display error message {string}")
    public void systemDisplayErrorMessage(String errorMessage) {
        Assert.assertEquals(login.getLoginMessageError(), errorMessage);
    }

    @When("user click burger button")
    public void userClickBurgerButton() {
        menu.clickBurgerButton();
        Assert.assertTrue(menu.displaySidebarList());
    }

    @And("user click logout link")
    public void userClickLogoutLink() throws InterruptedException {
        menu.clickLogoutLink();
    }

    @Then("user should see display form login")
    public void userShouldSeeDisplayFormLogin() {
        Assert.assertTrue(login.displayFromLogin());
    }

    @And("user successfully using username {string} and password {string}")
    public void userSuccessfullyUsingUsernameAndPassword(String username, String password) throws InterruptedException {
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickOnLoginButton();
    }

}
