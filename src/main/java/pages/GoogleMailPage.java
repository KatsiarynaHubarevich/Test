package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import sun.plugin2.message.Message;

public class GoogleMailPage extends BasePage {

    String messageSubject;

    @FindBy(xpath = "//*[@class='gb_Xa']")
    WebElementFacade gmailLogo;

    @FindBy(xpath = "//*[contains(text(), 'Compose')]")
    WebElementFacade composeButton;

    @FindBy(name = "to")
    WebElementFacade recipientsField;

    @FindBy(name = "subjectbox")
    WebElementFacade subjectField;

    @FindBy(xpath = "//div[@aria-label='Message Body']")
    WebElementFacade messageField;

    @FindBy(xpath = "//div[contains(@aria-label, 'Send')]")
    WebElementFacade sendButton;

    @FindBy(xpath = "//span[@class='gb_ab gbii']")
    WebElementFacade accountLogo;

    @FindBy(id = "gb_71")
    WebElementFacade signOutButton;

    @FindBy(xpath = "//*[contains(text(), 'Message sent')]")
    WebElementFacade messageSendNotification;

    @FindBy(xpath = "//table//tbody//tr[1]//span[@class='bog']//span")
    WebElementFacade subjectOfReceivedMessage;

    public void checkGoogleMailPageAppears() {
        gmailLogo.shouldBeVisible();
    }

    public void clickComposeButton() {
        composeButton.click();
    }

    public void enterRecipients(String recipients) {
        recipientsField.sendKeys(recipients);
    }

    public void enterSubject(String subject) {
        subjectField.sendKeys(subject);
        messageSubject = subject;
    }

    public void enterMessage(String message) {
        messageField.sendKeys(message);
    }

    public void clickSendButton() {
        sendButton.click();
    }

    public void clickSignOutButton() {
        accountLogo.click();
        signOutButton.click();
    }

    public void checkMessageSendNotificationAppears() {
        waitFor(messageSendNotification);
        messageSendNotification.shouldBeVisible();
    }

    public void checkMessageWasReceived() {
        subjectOfReceivedMessage.getText();
        subjectOfReceivedMessage.shouldContainText(messageSubject);
    }
}
