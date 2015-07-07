package reseller.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by rusu on 3/26/15.
 */

public class BasePage extends PageObject {
    public BasePage(WebDriver driver) {
        super(driver);
    }

    public void click_me(WebElementFacade e, By buttonLocator) {
        waitFor(ExpectedConditions.elementToBeClickable(buttonLocator));
        e.click();
    }
}
