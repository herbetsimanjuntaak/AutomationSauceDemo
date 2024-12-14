package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.SeleniumHelpers;

public class MenuPO {
    WebDriver driver;
    SeleniumHelpers selenium;
    Logger logger = LoggerFactory.getLogger(MenuPO.class);

    public MenuPO(WebDriver driver) {
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

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuButton;

    @FindBy(xpath = "//nav[@class='bm-item-list']")
    private WebElement sidebarList;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutLink;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetLink;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsLink;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    /**
     * Ensures that the burger menu button is visible in the current viewport.
     * This method checks if the burger menu button is displayed in the current view of the page.
     *
     * @return Boolean - Returns true if the burger menu button is visible in the viewport, otherwise false.
     */
    public Boolean displayBurgerMenu() {
        boolean isVisible = selenium.isVisibleInViewport(burgerMenuButton);
        if (isVisible) {
            logger.info("Burger menu button is visible in the viewport.");
        } else {
            logger.warn("Burger menu button is not visible in the viewport.");
        }
        return isVisible;
    }

    /**
     * Clicks on the burger menu button and logs the action.
     * This method attempts to click on the burger menu button and logs whether the action was successful or not.
     * If an exception occurs, it logs the error with the exception message.
     */
    public void clickBurgerButton() {
        try {
            selenium.clickOn(burgerMenuButton);
            logger.info("Burger menu button clicked successfully.");
        } catch (Exception e) {
            logger.error("Error occurred while clicking burger menu button: {}", e.getMessage(), e);
        }
    }

    /**
     * Clicks on the logout link and logs the action.
     * This method attempts to click on the logout link and logs whether the action was successful or not.
     * It throws an InterruptedException in case of a delay during the click action.
     *
     * @throws InterruptedException If the thread is interrupted during the execution.
     */
    public void clickLogoutLink() throws InterruptedException {
        try {
            selenium.clickOn(logoutLink);
            logger.info("Logout link clicked successfully.");
        } catch (Exception e) {
            logger.error("Error occurred while clicking logout link: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * Clicks on the About link and logs the action.
     * This method attempts to click on the About link and logs whether the action was successful or not.
     * If an exception occurs, it logs the error with the exception message.
     */
    public void clickAboutLink() {
        try {
            selenium.clickOn(aboutLink);
            logger.info("About link clicked successfully.");
        } catch (Exception e) {
            logger.error("Error occurred while clicking on About link: {}", e.getMessage(), e);
        }
    }



    /**
     * Checks if the sidebar list is visible in the current viewport.
     * This method uses the Selenium utility to verify the visibility of the sidebar list element within the viewport.
     *
     * @return Boolean - Returns true if the sidebar list is visible in the viewport, otherwise false.
     */
    public Boolean displaySidebarList() {
        return selenium.isVisibleInViewport(sidebarList);
    }

    /**
     * Clicks on the Reset Application link and logs the action.
     * This method attempts to click on the reset link and logs whether the action was successful or not.
     * If an exception occurs, it logs the error with the exception message.
     */
    public void clickResetAppLink() {
        try {
            selenium.clickOn(resetLink);
            logger.info("Reset Application link clicked successfully.");
        } catch (Exception e) {
            logger.error("Error occurred while clicking on Reset Application link: {}", e.getMessage(), e);
        }
    }

    /**
     * Retrieves the current URL of the page.
     * This method returns the URL of the currently loaded page in the browser.
     *
     * @return String - The URL of the current page.
     */
    public String getCurrentURL() {
        String currentURL = selenium.getURL();
        logger.info("Retrieved current URL: {}", currentURL);
        return currentURL;
    }

}
