package reseller.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by rusu on 3/24/15.
 */

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public WebElementFacade dashboard() {
        return find(By.className("h2.dashboard-title"));
    }

    public WebElementFacade resellerTeam() {
        WebElementFacade e;
        e = find(By.cssSelector("a[href='/team']"));
        return e;
    }

    public WebElementFacade organizationDetails() {
        WebElementFacade e;
        e = find(By.cssSelector("a[href='/organization-details']"));
        return e;
    }

    public WebElementFacade customers() {
        WebElementFacade e;
        e = find(By.cssSelector("a[href='/customers']"));
        e.waitUntilVisible();
        return e;
    }

    public void launch_resellerTeam() {
        resellerTeam().click();
    }

    public void launch_organizationDetails() {
        organizationDetails().click();
    }

    public void launch_customers() {
        customers().click();
    }
}
