package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class ProductPOs {

    WebDriver driver;
    SeleniumHelpers selenium;
    Logger logger = LoggerFactory.getLogger(ProductPOs.class);


    public ProductPOs(WebDriver driver) {
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

    @FindBy(xpath = "//div[@class='inventory_item_name ']")
    private List<WebElement> productNameList;

    @FindBy(xpath = "//button[text()='Add to cart']")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//button[text()='Remove']")
    private List<WebElement> removeButtons;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement productSortDropdown;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> priceList;


    /**
     * Checks if all products in the product list are visible on the page.
     * <p>
     * This method iterates through the list of products and verifies their visibility
     * using the `isElementAppeared` method. If any product is not visible, the method
     * immediately returns `false`. If all products are visible, it returns `true`.
     *
     * @return Boolean - `true` if all products are visible, otherwise `false`.
     */
    public Boolean displayProductList() {
        for (WebElement product : productNameList) {
            if (!selenium.isElementAppeared(product)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Verifies that all 'Add to Cart' buttons are visible on the page.
     * <p>
     * This method iterates through the list of 'Add to Cart' buttons and checks their visibility
     * using the `isElementAppeared` method. If any button is not visible, the method returns `false`.
     * If all buttons are visible, it returns `true`.
     *
     * @return Boolean - `true` if all 'Add to Cart' buttons are visible, otherwise `false`.
     */
    public Boolean displayAddToCartButton() {
        for (WebElement button : addToCartButtons) {
            if (!selenium.isElementAppeared(button)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Clicks the 'Add to Cart' button for the product at the specified index.
     * <p>
     * This method retrieves the 'Add to Cart' button for the product at the provided index and performs a click action on it.
     * Ensure that the provided index is within the bounds of the list to avoid runtime exceptions.
     *
     * @param index The index of the product's 'Add to Cart' button to click.
     * @throws InterruptedException If the click action is interrupted during execution.
     */
//    public void clickAddToCartButton(int index) throws InterruptedException {
//        System.out.println(addToCartButtons.get(index));
//        System.out.println(addToCartButtons.size());
//        if (index < 0 || index >= addToCartButtons.size()) {
//            return;
//        }
//        selenium.clickOn(addToCartButtons.get(index));
//    }
    public void clickAddToCartButton() throws InterruptedException {
        if (addToCartButtons.isEmpty()) {
            return;
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(addToCartButtons.size());
        System.out.println("Clicked Add to Cart at index: " + randomIndex);
        selenium.clickOn(addToCartButtons.get(randomIndex));

    }


    /**
     * Checks if the 'Remove' button for the product at the specified index is displayed.
     * <p>
     * This method checks whether the 'Remove' button for the product at the provided index is visible on the page.
     * Ensure the provided index is valid to avoid runtime errors.
     *
     * @param index The index of the product's 'Remove' button to check.
     * @return boolean - `true` if the 'Remove' button is visible, `false` otherwise.
     */
//    public boolean isRemoveButtonDisplayed(int index) {
//        if (index < 0 || index >= removeButtons.size()) {
//            return false;
//        }
//        WebElement removeButton = removeButtons.get(index);
//        return selenium.isElementAppeared(removeButton);
//    }

    public boolean isRemoveButtonDisplayed() {
        if (removeButtons.isEmpty()) {
            return false;
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(removeButtons.size());
        System.out.println("isRemoveButtonDisplayed at index: " + randomIndex);
        return selenium.isElementAppeared(removeButtons.get(randomIndex));

    }


    /**
     * Clicks the 'Remove' button for the product at the specified index in the list of products.
     * <p>
     * This method retrieves the 'Remove' button for the product at the given index and clicks it.
     * Ensure the provided index is valid to avoid runtime errors.
     *
     * @param index The index of the product's 'Remove' button to click.
     */
//    public void clickRemoveButton(int index) throws InterruptedException {
//        if (index < 0 || index >= removeButtons.size()) {
//            return;
//        }
//        WebElement removeButton = removeButtons.get(index);
//        selenium.clickOn(removeButton);
//    }
    public void clickRemoveButton() throws InterruptedException {
        if (removeButtons.isEmpty()) {
            return;
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(removeButtons.size());
        System.out.println("Clicked Remove button at index: " + randomIndex);
        selenium.clickOn(removeButtons.get(randomIndex));

    }

    public boolean isAddToCartButtonDisplayed() {
        if (addToCartButtons.isEmpty()) {
            return false;
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(addToCartButtons.size());
        System.out.println("isAddToCartButtonDisplayed at index: "+randomIndex);
        return selenium.isElementAppeared(addToCartButtons.get(randomIndex)); // Verifikasi bahwa tombol "Add to Cart" ditampilkan
    }



    /**
     * Retrieves the current item count displayed in the shopping cart.
     * <p>
     * This method extracts the text from the shopping cart link, which indicates
     * the number of items currently in the cart.
     *
     * @return String - The text representing the current item count in the cart.
     */
    public String getCartItemCount() {
        return selenium.getText(cartLink);
    }


    /**
     * Clicks on the sorting dropdown for the products.
     * This method clicks on the sorting dropdown directly.
     * Ensure the dropdown is visible and clickable before calling this method.
     *
     * @throws InterruptedException If the thread is interrupted during the click action.
     */
    public void clickSortingDropdown() throws InterruptedException {
        selenium.clickOn(productSortDropdown);
    }

    /**
     * Selects a sorting option from the dropdown.
     * This method interacts with the sorting dropdown and selects the option based on the visible text.
     * Logs the result of the selection.
     *
     * @param option The visible text of the sorting option to be selected.
     */
    public void selectSortingOption(String option) {
        try {
            new Select(productSortDropdown).selectByVisibleText(option);
            logger.info("Sorting option '{}' selected successfully.", option);
        } catch (Exception e) {
            logger.error("Error selecting sorting option '{}': {}", option, e.getMessage());
        }
    }


    /**
     * Verifies if the product list is sorted by name in ascending order.
     * This method compares the current order of product names with a sorted version of the list.
     * If the current order matches the sorted order, it returns true, indicating the list is sorted.
     * Otherwise, it returns false.
     *
     * @return boolean Returns `true` if the product list is sorted by name in ascending order, `false` otherwise.
     */
    public boolean isProductListSortedByNameAscending() {
        List<String> productNames = productNameList.stream()
                .map(WebElement::getText)
                .toList();

        List<String> sortedNames = new ArrayList<>(productNames);
        Collections.sort(sortedNames);

        return productNames.equals(sortedNames);
    }


    /**
     * Verifies if the product list is sorted by name in descending order.
     * This method compares the current order of product names with a sorted version of the list in reverse order.
     * If the current order matches the sorted (descending) order, it returns true, indicating the list is sorted in descending order.
     * Otherwise, it returns false.
     *
     * @return boolean Returns `true` if the product list is sorted by name in descending order, `false` otherwise.
     */
    public boolean isProductListSortedByNameDescending() {
        List<String> productNames = productNameList.stream()
                .map(WebElement::getText)
                .toList();


        List<String> sortedNames = new ArrayList<>(productNames);
        sortedNames.sort(Collections.reverseOrder());

        return productNames.equals(sortedNames);
    }


    /**
     * Verifies if the product list is sorted by price in descending order.
     * This method compares the current order of product prices with a sorted version of the list in reverse order.
     * If the current order matches the sorted (descending) order, it returns true, indicating the list is sorted by price in descending order.
     * Otherwise, it returns false.
     *
     * @return boolean Returns `true` if the product list is sorted by price in descending order, `false` otherwise.
     */
    public boolean isProductListSortedByPriceDescending() {
        List<Double> productPrices = priceList.stream()
                .map(priceElement -> {
                    String priceText = priceElement.getText();
                    return Double.parseDouble(priceText.replace("$", ""));
                })
                .toList();

        List<Double> sortedPrices = new ArrayList<>(productPrices);
        sortedPrices.sort(Collections.reverseOrder());

        return productPrices.equals(sortedPrices);
    }

    /**
     * Verifies if the product list is sorted by price in ascending order.
     * This method compares the current order of product prices with a sorted version of the list in ascending order.
     * If the current order matches the sorted (ascending) order, it returns true, indicating the list is sorted by price in ascending order.
     * Otherwise, it returns false.
     *
     * @return boolean Returns `true` if the product list is sorted by price in ascending order, `false` otherwise.
     */
    public boolean isProductListSortedByPriceAscending() {
        List<Double> productPrices = priceList.stream()
                .map(priceElement -> {
                    String priceText = priceElement.getText();
                    return Double.parseDouble(priceText.replace("$", ""));
                })
                .toList();

        List<Double> sortedPrices = new ArrayList<>(productPrices);
        Collections.sort(sortedPrices);

        return productPrices.equals(sortedPrices);
    }



//    public boolean isAddToCartButtonDisplayed() {
//        // Check if the list of 'Add to Cart' buttons is not empty and the first button is displayed
//        if (!addToCartButtons.isEmpty() && addToCartButtons.getFirst().isDisplayed()) {
//            return selenium.isElementAppeared(addToCartButtons.getFirst());
//        }
//        return false;
//    }



}
