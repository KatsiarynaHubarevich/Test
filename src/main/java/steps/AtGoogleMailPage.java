package steps;

import net.thucydides.core.annotations.Step;
import pages.GoogleMailPage;

public class AtGoogleMailPage {

    GoogleMailPage onPage;

    @Step
    public void checkGoogleMailPageAppears() {
        waitForPageToLoad();
        onPage.checkGoogleMailPageAppears();
    }

    @Step
    public void clickComposeButton() {
        onPage.clickComposeButton();
    }

    @Step
    public void waitForPageToLoad() {
        onPage.waitForPageToLoad();
    }

    @Step
    public void enterRecipients(String recipients) {
        onPage.enterRecipients(recipients);
    }

    @Step
    public void enterSubject(String subject) {
        onPage.enterSubject(subject);
    }

    @Step
    public void enterMessage(String message) {
        onPage.enterMessage(message);
    }

    @Step
    public void clickSendButton() {
        onPage.clickSendButton();
    }

    @Step
    public void clickSignOutButton() {
        onPage.clickSignOutButton();
    }

    @Step
    public void checkMessageSendNotificationAppears() {
        onPage.checkMessageSendNotificationAppears();
    }

    @Step
    public void checkMessageWasReceived() {
        onPage.checkMessageWasReceived();
    }
}
