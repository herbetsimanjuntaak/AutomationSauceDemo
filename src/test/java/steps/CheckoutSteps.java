package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobject.ChekcoutPO;
import pageobject.MenuPO;
import pageobject.ProductPO;
import utilities.ThreadManager;

public class CheckoutSteps {

    private final WebDriver driver = ThreadManager.getDriver();
    private final ProductPO product = new ProductPO(driver);
    private final MenuPO menu = new MenuPO(driver);
    private final ChekcoutPO chekcoutPO = new ChekcoutPO();


    @Then("user click button checkout")
    public void userClickButtonCheckout() {
    }
}
