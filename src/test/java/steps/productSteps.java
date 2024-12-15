package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import pageobject.ProductPO;

import utilities.JavaHelpers;
import utilities.ThreadManager;

import java.util.List;

public class productSteps {

    private final WebDriver driver = ThreadManager.getDriver();
    private final ProductPO product = new ProductPO(driver);
    private final JavaHelpers javaHelpers = new JavaHelpers();


    @When("user views the product list")
    public void userViewsTheProductList() {
        Assert.assertTrue(product.displayProductList());
    }

    @Then("system displays the Add to Cart button for all products")
    public void systemDisplaysTheAddToCartButtonForAllProducts() {
        Assert.assertTrue(product.displayAddToCartButton());
    }

    @When("user clicks on the Add to Cart button for a product")
    public void userClicksOnTheAddToCartButtonForAProduct() throws InterruptedException {
        product.clickAddToCartButton();
        product.clickAddToCartButton();
        product.clickAddToCartButton();
        product.clickAddToCartButton();
    }

    @Then("the Add to Cart button for that product should change to Remove")
    public void theAddToCartButtonForThatProductShouldChangeToRemove() {
//        System.out.println(product.getButtonText(1));
        Assert.assertTrue(product.isRemoveButtonDisplayed(1));
        product.soutsss();
        //new herbet
    }

    @When("user clicks on the Add to Cart button for a different product")
    public void userClicksOnTheAddToCartButtonForADifferentProduct() throws InterruptedException {
        product.clickAddToCartButton();
    }

    @Then("the number on the cart icon changes to {string}")
    public void theNumberOnTheCartIconChangesTo(String cartCount) {
        Assert.assertEquals(product.getCartItemCount(), cartCount);
    }

    @When("user clicks on the Remove button for one of the products list")
    public void userClicksOnTheRemoveButtonForOneOfTheProductsList() throws InterruptedException {
        product.clickRemoveButton();
    }

    @Given("user has added 2 products to the cart")
    public void userHasAddedProductsToTheCart() throws InterruptedException {
        product.clickAddToCartButton();
        product.clickAddToCartButton();
    }

    @And("user selects {string} from the sorting options")
    public void userSelectsFromTheSortingOptions(String sortingOption) throws InterruptedException {
        product.clickSortingOption(sortingOption);
    }

    @Then("the product list should be displayed in ascending order by product name")
    public void theProductListShouldBeDisplayedInAscendingOrderByProductName() {
        Assert.assertTrue(product.isProductListSortedByNameAscending());
    }

    @Then("the product list should be displayed in descending order by product name")
    public void theProductListShouldBeDisplayedInDescendingOrderByProductName() {
        Assert.assertTrue(product.isProductListSortedByNameDescending());
    }

    @Then("the product list should be displayed in descending order by price name")
    public void theProductListShouldBeDisplayedInDescendingOrderByPriceName() {
        Assert.assertTrue(product.isProductListSortedByPriceDescending());
    }

    @Then("the product list should be displayed in ascending order by price name")
    public void theProductListShouldBeDisplayedInAscendingOrderByPriceName() {
        Assert.assertTrue(product.isProductListSortedByPriceAscending());
    }


    //cart


    @And("user clicks on the Remove button for one of the products in the cart")
    public void userClicksOnTheRemoveButtonForOneOfTheProductsInTheCart() throws InterruptedException {
        product.clickRemoveButton();
    }

    @Then("the Remove button should change to Add to Cart")
    public void theRemoveButtonShouldChangeToAddToCart() {
        Assert.assertTrue(product.isAddToCartButtonDisplayed());
    }

    @And("the cart icon should be empty")
    public void theCartIconShouldBeEmpty() {
        Assert.assertEquals(product.getCartItemCount(), "");
    }


    @Then("system displays product list based on product price from the {string}")
    public void systemDisplaysProductListBasedOnProductPriceFromThe(String sortBy) {
        List<Double> priceList = product.getProductPriceList();
        boolean isSort = javaHelpers.isDataSorted(priceList, sortBy);
        Assert.assertTrue(isSort);
    }
}
