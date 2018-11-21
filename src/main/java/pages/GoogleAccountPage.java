package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class GoogleAccountPage extends BasePage {

    @FindBy(id = "identifierId")
    WebElementFacade emailAddressField;

    @FindBy(xpath = "//div[@class='qhFLie']")
    WebElementFacade nextButton;

    @FindBy(name = "password")
    WebElementFacade passwordField;

    @FindBy(id = "profileIdentifier")
    WebElementFacade selectAccountDropDown;

    @FindBy(xpath = "//div[@id='identifierLink']//div[@class='vdE7Oc f3GIQ']")
    WebElementFacade changeAccountButton;

    public void enterEmailAddress(String email) {
        emailAddressField.sendKeys(email);
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public void enterPassword(String password) {

        passwordField.sendKeys(password);
    }

    public void changeAccount() {
        selectAccountDropDown.click();
        waitForElementToBeClickable(changeAccountButton);
        changeAccountButton.click();
    }
}
