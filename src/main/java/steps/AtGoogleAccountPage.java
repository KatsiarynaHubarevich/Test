package steps;

import net.thucydides.core.annotations.Step;
import pages.GoogleAccountPage;

public class AtGoogleAccountPage {
    GoogleAccountPage onPage;

    @Step
    public void enterEmailAddress (String email) {
        onPage.enterEmailAddress(email);
    }

    @Step
    public void clickNextButton(){
        onPage.clickNextButton();
    }

    @Step
    public void enterPassword(String password){
        onPage.enterPassword(password);
    }

    @Step
    public void changeAccount(){
        onPage.changeAccount();
    }
}
