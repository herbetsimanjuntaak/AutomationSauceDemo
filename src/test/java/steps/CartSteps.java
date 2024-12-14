package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.CartPO;
import pageobject.ProductPO;
import utilities.ThreadManager;

import static org.testng.Assert.assertTrue;

public class CartSteps {

    private final WebDriver driver = ThreadManager.getDriver();
    private final CartPO cartPO = new CartPO(driver);
    private final ProductPO product = new ProductPO(driver);

    @Given("user is on the cart page")
    public void userIsOnTheCartPage() throws InterruptedException {
        cartPO.clickOnCartLink();
    }

    @When("user clicks on the cart link")
    public void userClicksOnTheCartLink() throws InterruptedException {
        cartPO.clickOnCartLink();
    }

    @Then("the system should display the cart page")
    public void theSystemShouldDisplayTheCartPage() {
        assertTrue(cartPO.isCartPageDisplayed());
    }

    @When("user clicks on the Continue Shopping button")
    public void userClicksOnTheContinueShoppingButton() throws InterruptedException {
        cartPO.clickContinueShopping();
    }

    @Then("the system should redirect to the product list page")
    public void theSystemShouldRedirectToTheProductListPage() {
        Assert.assertTrue(product.displayProductList());
    }


    @Then("The removed product should not appear in the cart")
    public void theRemovedProductShouldNotAppearInTheCart() {
//        Assert.assertTrue(cartPO.isProductNotInCart2("Sauce Labs Backpack"));
        Assert.assertTrue(cartPO.isProductNotInCart());
    }


    @Given("user has added 2 products in the cart and is on the cart page")
    public void userHasAddedProductsInTheCartAndIsOnTheCartPage() throws InterruptedException {
        product.clickAddToCartButton();
        product.clickAddToCartButton();
        cartPO.clickOnCartLink();
    }
}
