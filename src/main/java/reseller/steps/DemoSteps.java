package reseller.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.testng.Assert;
import reseller.pages.DemoPage;

/**
 * Created by rusu on 3/24/15.
 */

public class DemoSteps extends BaseSteps {

    static DemoPage demoPage;

    public DemoSteps() {
        super();
    }


    public DemoSteps(Pages pages) {
        super(pages);
    }

    public void setPages(Pages pages) {
        this.setPages(pages);
    }

    public DemoPage demoPage() {
        demoPage = getPages().currentPageAt(DemoPage.class);
        return demoPage;
    }

    @Step("Wait a bit until the page will become available")
    public void waitABit() {
        demoPage().wait_A_Bit();
    }

    @Step("Click the button: \"Get Started\"")
    public void getStarted() {
        demoPage().launch_GetStarted();
    }

    @Step
    public void failed_step() {
        Assert.fail("Failed!");
    }

}
