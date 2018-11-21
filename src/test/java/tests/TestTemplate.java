package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.GlobalSteps;
import utils.properties.Config;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@RunWith(SerenityRunner.class)
public class TestTemplate {

    @Steps
    public GlobalSteps globalSteps;

    @Managed
    public WebDriver driver;

    @Before
    public void startApp() {
        getDriver().manage().window().maximize();
        getDriver().navigate().to(Config.getApplicationUrl());
    }

    @After
    public void closeApp() {
        getDriver().close();
    }
}
