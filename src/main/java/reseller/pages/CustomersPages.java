package reseller.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by rusu on 3/24/15.
 */
public class CustomersPages extends BasePage {

    private By addButtonLocator = By.cssSelector("div.site-toolbar-menu button.site-toolbar-menu-button.icon-add-circle.no-icon-margins.ng-scope");

    public CustomersPages(WebDriver driver) {
        super(driver);
    }

    public WebElementFacade addButton() {
        return find(addButtonLocator);
    }

    public void clickAddButton() {
        click_me(addButton(), addButtonLocator);
    }
}
