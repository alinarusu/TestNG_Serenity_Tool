package reseller.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by rusu on 3/24/15.
 */
public class DemoPage extends BasePage {

    public DemoPage(WebDriver driver) {
        super(driver);
    }

    public WebElementFacade getStarted() {
        WebElementFacade e;
        e = find(By.cssSelector("a.get-started-action.ng-scope"));
        return e;
    }

    public void wait_A_Bit() {
        waitABit(1000);
    }

    public void launch_GetStarted() {
        getStarted().waitUntilVisible().click();
    }
}
