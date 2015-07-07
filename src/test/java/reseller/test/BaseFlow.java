package reseller.test;

import net.sf.cglib.proxy.Enhancer;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import reseller.steps.*;
import reseller.tools.MyStepInterceptor;

/**
 * Created by rusu on 3/27/15.
 */

@Listeners({reseller.tools.MyInvokedMethodListener.class})

public class BaseFlow {
    public static final String orgName = "Adobe";
    public static final String adr1 = "Bucharest";
    public static final String adr2 = "Madrid";
    public static final String city = "Bucharest";
    public static final String zipCode = "060029";
    public static final String email = "my_username@gmail.com";
    public static final String firstName = "User";
    public static final String lastName = "Name";
    public static final int index = 1;
    public static final int indexCountry = 9;
    public static final int indexState = 2;
    public static final String teamMember = "my_username@adobe.com";
    @Managed(uniqueSession = true)
    public static WebDriver driver;
    protected DemoSteps demoSteps;
    protected DashboardSteps dashboardSteps;
    protected TeamSteps teamSteps;
    protected CustomersSteps customersSteps;
    protected MPendingRequestSteps mPendingRequestSteps;
    protected MPendingInvitationsSteps mPendingInvitationsSteps;
    protected MNoProductsSteps mNoProductsSteps;
    protected MAddCustomerOrgSteps mAddCustomerOrgSteps;
    @Steps
    protected DemoSteps demoSteps1;
    @Steps
    protected DashboardSteps dashboardSteps1;
    @Steps
    protected TeamSteps teamSteps1;
    @Steps
    protected CustomersSteps customersSteps1;
    @Steps
    protected MPendingRequestSteps mPendingRequestSteps1;
    @Steps
    protected MPendingInvitationsSteps mPendingInvitationsSteps1;
    @Steps
    protected MNoProductsSteps mNoProductsSteps1;
    @Steps
    protected MAddCustomerOrgSteps mAddCustomerOrgSteps1;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        //configuration.setDefaultBaseUrl("https://reseller.adobe.com/demo");

        demoSteps1 = new DemoSteps(new Pages(driver));
        demoSteps = getProxyForStepClass(DemoSteps.class, demoSteps1);


        dashboardSteps1 = new DashboardSteps(new Pages(driver));
        dashboardSteps = getProxyForStepClass(DashboardSteps.class, dashboardSteps1);

        teamSteps1 = new TeamSteps(new Pages(driver));
        teamSteps = getProxyForStepClass(TeamSteps.class, teamSteps1);

        customersSteps1 = new CustomersSteps(new Pages(driver));
        customersSteps = getProxyForStepClass(CustomersSteps.class, customersSteps1);

        mPendingInvitationsSteps1 = new MPendingInvitationsSteps(new Pages(driver));
        mPendingInvitationsSteps = getProxyForStepClass(MPendingInvitationsSteps.class, mPendingInvitationsSteps1);

        mPendingRequestSteps1 = new MPendingRequestSteps(new Pages(driver));
        mPendingRequestSteps = getProxyForStepClass(MPendingRequestSteps.class, mPendingRequestSteps1);

        mNoProductsSteps1 = new MNoProductsSteps(new Pages(driver));
        mNoProductsSteps = getProxyForStepClass(MNoProductsSteps.class, mNoProductsSteps1);

        mAddCustomerOrgSteps1 = new MAddCustomerOrgSteps(new Pages(driver));
        mAddCustomerOrgSteps = getProxyForStepClass(MAddCustomerOrgSteps.class, mAddCustomerOrgSteps1);

        driver.get("https://reseller.adobe.com/demo");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

//---------------------- Proxy -----------------------//

    private <T> T getProxyForStepClass(Class<T> scenarioStepsClass, T t) {
        Enhancer e = new Enhancer();
        e.setSuperclass(scenarioStepsClass);
        e.setCallback(new MyStepInterceptor(t));
        T proxyStep = (T) e.create();
        return proxyStep;
    }
}
