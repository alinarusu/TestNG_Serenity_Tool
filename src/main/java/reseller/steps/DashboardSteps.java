package reseller.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import reseller.pages.DashboardPage;

/**
 * Created by rusu on 3/24/15.
 */

public class DashboardSteps extends BaseSteps {
    public DashboardSteps() {
        super();
    }

    public DashboardSteps(Pages pages) {
        super(pages);
    }

    public DashboardPage dashboardPage() {
        return getPages().currentPageAt(DashboardPage.class);
    }

    @Step
    public void clickOnResellerTeam() {
        dashboardPage().launch_resellerTeam();
    }

    @Step
    public void click_on_launch_organizationDetails() {
        dashboardPage().launch_organizationDetails();
    }

    @Step("Click the button: \"Customers\"")
    public void clickOnCustomers() {
        dashboardPage().launch_customers();
    }
}
