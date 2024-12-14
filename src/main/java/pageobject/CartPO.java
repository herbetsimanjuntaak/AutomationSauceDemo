package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.util.List;

public class CartPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public CartPO(WebDriver driver) {
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

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    @FindBy(id = "cart_contents_container")
    private WebElement cartPageContents;

    @FindBy(xpath = "//div[@class='cart_item']")
    private List<WebElement> cartItems;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    /**
     * Click on the cart icon to navigate to the cart page.
     *
     * @throws InterruptedException if there is an interruption while waiting for the click process.
     */
    public void clickOnCartLink() throws InterruptedException {
        selenium.clickOn(cartLink);
    }

    /**
     * Verify if the cart page is displayed.
     *
     * @return Boolean true if the cart page has loaded, false if it has not.
     */
    public Boolean isCartPageDisplayed() {
        return selenium.isElementAppeared(cartPageContents);
    }

    /**
     * Click on the cart icon to navigate to the cart page.
     *
     * @throws InterruptedException if there is an interruption while waiting for the click process.
     */
    public void clickContinueShopping() throws InterruptedException {
        selenium.clickOn(continueShoppingButton);
    }


    public boolean isProductNotInCart2(String productName) {
        for (WebElement item : cartItems) {
            WebElement productTitle = item.findElement(By.className("inventory_item_name"));
            if (productTitle.getText().equals(productName)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifies if the cart contains exactly one item, which may indicate that no additional products are in the cart.
     *
     * @return true if the cart contains exactly one item, false otherwise.
     */
    public boolean isProductNotInCart() {
        return cartItems.size() == 1;
    }

}
