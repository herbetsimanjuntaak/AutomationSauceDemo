package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.MenuPO;
import utilities.ThreadManager;

public class MenuSteps {

    private final WebDriver driver = ThreadManager.getDriver();
    private final MenuPO menu = new MenuPO(driver);

    @When("user clicks on the burger menu")
    public void userClicksOnTheBurgerMenu() {
        menu.clickBurgerButton();
    }

    @And("user selects About from the menu options")
    public void userSelectsAboutFromTheMenuOptions() {
        menu.clickAboutLink();
    }

    @Then("the system should redirect to {string}")
    public void theSystemShouldRedirectTo(String expectedURL) {
        Assert.assertEquals(menu.getCurrentURL(), expectedURL);
    }

    @Then("user should see display sidebar menu")
    public void userShouldSeeDisplaySidebarMenu() {
        Assert.assertTrue(menu.displaySidebarList());
    }

    @When("user clicks Reset App State on the sidebar menu")
    public void userClicksResetAppStateOnTheSidebarMenu() {
        menu.clickResetAppLink();
    }
}
