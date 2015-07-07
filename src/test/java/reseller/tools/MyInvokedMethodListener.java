package reseller.tools;

import net.thucydides.core.model.Stories;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.reports.ReportService;
import net.thucydides.core.steps.BaseStepListener;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.Configuration;
import net.thucydides.core.webdriver.ThucydidesWebdriverManager;
import net.thucydides.core.webdriver.WebDriverFactory;
import net.thucydides.core.webdriver.WebdriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import reseller.test.BaseFlow;

import java.io.File;

/**
 * Created by rusu on 4/24/15.
 */
public class MyInvokedMethodListener implements IInvokedMethodListener {

    protected static final Logger LOGGER = LoggerFactory.getLogger(MyInvokedMethodListener.class);
    protected BaseStepListener baseStepListener;
    protected ReportService reportService;
    WebDriverFactory webDriverFactory = new WebDriverFactory();
    private EnvironmentVariables environmentVariables = new MyEnvironmentVariables();
    protected Configuration configuration = new MyConfiguration(environmentVariables);
    private WebdriverManager webdriverManager = new ThucydidesWebdriverManager(webDriverFactory, configuration);

    public MyInvokedMethodListener() {
        baseStepListener = new BaseStepListener(FirefoxDriver.class, new File("/Users/rusu/Test/Serenity/target/site/serenity"), configuration);
        StepEventBus.getEventBus().registerListener(baseStepListener);
    }

    public static BaseStepListener withOutputDirectory(File outputDirectory) {
        return new BaseStepListener(outputDirectory);
    }

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        System.out.println("[IInvokedMethod - beforeInvocation] " + iInvokedMethod.getTestMethod().getMethodName());
        if (iTestResult.getMethod().isTest()) {
            String test = iTestResult.getName();
            notifyTestStarted(test, iInvokedMethod.getTestMethod().getTestClass().getRealClass());
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        System.out.println("[IInvokedMethod - afterInvocation] " + iInvokedMethod.getTestMethod().getMethodName());
        if (iInvokedMethod.getTestMethod().isBeforeClassConfiguration()) {
            baseStepListener.setDriver(BaseFlow.driver);
        } else {
            if (iInvokedMethod.getTestMethod().isTest()) {
                Stories.findStoryFrom(iInvokedMethod.getTestMethod().getTestClass().getRealClass());
                notifyTestFinished();
            } else {
                if (iInvokedMethod.getTestMethod().isAfterClassConfiguration()) {
                    System.out.println(iTestResult.getMethod().getMethodName());
                    generateReports();
                    notifyTestSuiteFinished();
                }
            }
        }
    }

    protected void generateReports() {
        getReportService().generateReportsFor(baseStepListener.getTestOutcomes());
    }

    private ReportService getReportService() {
        if (reportService == null) {
            reportService = new ReportService(new File("/Users/rusu/Test/Serenity/target/site/serenity"), ReportService.getDefaultReporters());
        }
        return reportService;
    }

    private void notifyTestStarted(String test, Class realClass) {
        StepEventBus.getEventBus().testSuiteStarted(realClass);
        StepEventBus.getEventBus().testStarted(test);

    }

    private void notifyTestFinished() {

        StepEventBus.getEventBus().testFinished();
    }

    private void notifyTestSuiteFinished() {
        try {
            StepEventBus.getEventBus().testSuiteFinished();
        } catch (Throwable listenerException) {
            // We report and ignore listener exceptions so as not to mess up the rest of the test mechanics.
            LOGGER.error("Test event bus error: " + listenerException.getMessage(), listenerException);
        }
    }

    protected BaseStepListener initBaseStepListenerUsing(Pages pageFactory) {
        return withOutputDirectory(new File("/Users/rusu/Test/Serenity/target/site/serenity"));
    }
}
