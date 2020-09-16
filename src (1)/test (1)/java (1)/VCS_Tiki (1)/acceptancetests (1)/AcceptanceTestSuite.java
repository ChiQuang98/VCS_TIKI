package VCS_Tiki.acceptancetests;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/", glue="VCS_Tiki")
public class AcceptanceTestSuite {
    @Managed (driver ="chrome")
    WebDriver chromeDriver;
}
