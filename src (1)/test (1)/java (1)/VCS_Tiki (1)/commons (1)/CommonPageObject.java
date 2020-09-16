package VCS_Tiki.commons;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*  ----
 * 	---- Author: DungNT
 */

public class CommonPageObject extends PageObject {
    public WebElementFacade getHighlightedElement(WebElementFacade elementFacade) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", elementFacade);
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        js.executeScript("arguments[0].setAttribute('style','');", elementFacade);
        return elementFacade;
    }

    public void waitUntilElementVisible(WebElementFacade elementFacade) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 50);
        wait.until(ExpectedConditions.visibilityOf(elementFacade));
    }

    public void waitUntilElementInvisible(String x) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(x)));
    }
    public void waitUntilJSReady(int timeoutInSeconds) {

        new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofSeconds(5)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                try {
                    JavascriptExecutor jsExec = (JavascriptExecutor) d;
                    return (Boolean) jsExec.executeScript("return document.readyState == complete");
                } catch (Exception e) {
                    return true;
                }
            }
        });
    }
    public void waitUntilAngularReady(int timeoutInSeconds) {
        new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofSeconds(5)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                try {
                    JavascriptExecutor jsExec = (JavascriptExecutor) d;
                    return (Boolean) jsExec.executeScript("return angular.element(document).injector() === undefined");
                } catch (Exception e) {
                    return true;
                }
            }
        });
    }

    public void waitUntilJQueryRequestCompleted(int timeoutInSeconds) {
        new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(5000)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                try {
                    JavascriptExecutor jsExec = (JavascriptExecutor) d;
                    return (Boolean) jsExec.executeScript("return jQuery.active == 0");
                } catch (Exception e) {
                    return true;
                }
            }
        });
    }

    public void waitUntilAjaxCompletes(int timeoutInSeconds) {
        new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(5000)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                try {
                    JavascriptExecutor jsExec = (JavascriptExecutor) d;
                    return (Boolean) jsExec.executeScript("return Ajax.activeRequestCount == 0");
                } catch (Exception e) {
                    return true;
                }
            }
        });
    }
    public void waitForAllJSComplete() {
        waitUntilJQueryRequestCompleted(30);
        waitUntilAjaxCompletes(30);
        waitUntilAngularReady(30);
        waitUntilJSReady(30);
    }
}