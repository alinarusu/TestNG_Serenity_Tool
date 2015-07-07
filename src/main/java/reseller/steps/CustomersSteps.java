package reseller.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import reseller.pages.CustomersPages;

/**
 * Created by rusu on 3/24/15.
 */

public class CustomersSteps extends BaseSteps {

    public CustomersSteps() {
        super();
    }

    public CustomersSteps(Pages pages) {
        super(pages);
    }

    public CustomersPages customersPages() {
        return getPages().currentPageAt(CustomersPages.class);
    }

    @Step("Click the button: \"Add\"")
    public void clickAddButton() {
        customersPages().clickAddButton();
    }
}
