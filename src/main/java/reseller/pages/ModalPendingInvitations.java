package reseller.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by rusu on 3/24/15.
 */
public class ModalPendingInvitations extends BasePage {
    public ModalPendingInvitations(WebDriver driver) {
        super(driver);
    }

    public boolean isMemberAdded(String email) {
        List<WebElementFacade> elements = findAll(By.cssSelector("div.customer-mini-profile div.js-link-parent a.no-text-decoration.ng-scope.ng-binding"));
        for (WebElementFacade element : elements) {
            if (element.getText().equals(email))
                return true;
        }
        return false;
    }
}
