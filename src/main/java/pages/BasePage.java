package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage extends PageObject {

    private static final int DRIVER_WAIT_TIME = 60;
    protected static final Logger LOG = LoggerFactory.getLogger(BasePage.class);

    public void waitForPageToLoad() {
        try {
            ExpectedCondition<Boolean> expectedCondition = new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    return getDocumentReadyState().equals("complete");
                }
            };
            Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
            wait.until(expectedCondition);
        } catch (Exception ex) {
            LOG.error("Fail waiting for ready document state. Current state is " + getDocumentReadyState());
        }
    }

    private String getDocumentReadyState() {
        return (String) ((JavascriptExecutor) getDriver()).executeScript("return document.readyState");
    }

    public void waitForElementToBeClickable(WebElementFacade element) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
