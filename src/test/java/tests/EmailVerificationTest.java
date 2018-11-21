package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.data.ExcelFileReader;
import utils.properties.Config;

@RunWith(SerenityRunner.class)
public class EmailVerificationTest extends TestTemplate {

    @Test
    public void checkEMailReceiving() {
        globalSteps.atGoogleAccountPage.enterEmailAddress(Config.getSenderEmail());
        globalSteps.atGoogleAccountPage.clickNextButton();
        globalSteps.atGoogleAccountPage.enterPassword(Config.getSenderPassword());
        globalSteps.atGoogleAccountPage.clickNextButton();
        globalSteps.atGoogleMailPage.checkGoogleMailPageAppears();

        globalSteps.atGoogleMailPage.clickComposeButton();
        globalSteps.atGoogleMailPage.enterRecipients(Config.getRecipientEmail());
        globalSteps.atGoogleMailPage.enterSubject(ExcelFileReader.getValueByColumnName("Subject"));
        globalSteps.atGoogleMailPage.enterMessage(ExcelFileReader.getValueByColumnName("Message"));
        globalSteps.atGoogleMailPage.clickSendButton();
        globalSteps.atGoogleMailPage.checkMessageSendNotificationAppears();

        globalSteps.atGoogleMailPage.clickSignOutButton();
        globalSteps.atGoogleAccountPage.changeAccount();
        globalSteps.atGoogleAccountPage.enterEmailAddress(Config.getRecipientEmail());
        globalSteps.atGoogleAccountPage.clickNextButton();
        globalSteps.atGoogleAccountPage.enterPassword(Config.getRecipientPassword());
        globalSteps.atGoogleAccountPage.clickNextButton();
        globalSteps.atGoogleMailPage.checkGoogleMailPageAppears();

        globalSteps.atGoogleMailPage.checkMessageWasReceived();

    }
}
