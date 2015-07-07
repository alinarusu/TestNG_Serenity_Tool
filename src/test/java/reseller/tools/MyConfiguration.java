package reseller.tools;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.model.TakeScreenshots;
import net.thucydides.core.steps.FilePathParser;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.Configuration;
import net.thucydides.core.webdriver.SupportedWebDriver;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

import static net.thucydides.core.ThucydidesSystemProperty.THUCYDIDES_STORE_HTML_SOURCE;
import static net.thucydides.core.ThucydidesSystemProperty.THUCYDIDES_TAKE_SCREENSHOTS;

/**
 * Created by rusu on 6/17/15.
 */
public class MyConfiguration implements Configuration {

    public static final String DEFAULT_WEBDRIVER_DRIVER = "firefox";
    public static final int DEFAULT_ELEMENT_TIMEOUT_SECONDS = 5;
    public static final Integer DEFAULT_ESTIMATED_AVERAGE_STEP_COUNT = 5;
    public static final String OUTPUT_DIRECTORY_PROPERTY = ThucydidesSystemProperty.THUCYDIDES_OUTPUT_DIRECTORY.getPropertyName();
    public static final String REFUSE_UNTRUSTED_CERTIFICATES
            = ThucydidesSystemProperty.REFUSE_UNTRUSTED_CERTIFICATES.getPropertyName();
    public static final String MAX_RETRIES = "max.retries";
    private static final String MAVEN_BUILD_DIRECTORY = "project.build.directory";
    private static final String MAVEN_REPORTS_DIRECTORY = "project.reporting.OutputDirectory";
    private static final String DEFAULT_OUTPUT_DIRECTORY = "target/site/serenity";
    public File outputDirectory = new File("/Users/rusu/Test/Serenity/target/site/serenity");
    public String defaultBaseUrl;
    private EnvironmentVariables environmentVariables;
    private FilePathParser filePathParser;

    @Inject
    public MyConfiguration(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
        filePathParser = new FilePathParser(environmentVariables);
    }

    @Override
    public SupportedWebDriver getDriverType() {
        return SupportedWebDriver.FIREFOX;
    }

    @Override
    public int getStepDelay() {
        int stepDelay = 0;

        String stepDelayValue = ThucydidesSystemProperty.THUCYDIDES_STEP_DELAY.from(environmentVariables);
        if ((stepDelayValue != null) && (!stepDelayValue.isEmpty())) {
            stepDelay = Integer.valueOf(stepDelayValue);
        }
        return stepDelay;
    }

    @Override
    public int getElementTimeout() {
        int elementTimeout = DEFAULT_ELEMENT_TIMEOUT_SECONDS;

        String stepDelayValue = ThucydidesSystemProperty.THUCYDIDES_TIMEOUT.from(environmentVariables);
        if ((stepDelayValue != null) && (!stepDelayValue.isEmpty())) {
            elementTimeout = Integer.valueOf(stepDelayValue);
        }
        return elementTimeout;
    }

    @Override
    public boolean getUseUniqueBrowser() {
        return false;
    }

    @Override
    public File getOutputDirectory() {
        return outputDirectory;
    }

    @Override
    public void setOutputDirectory(File outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    @Override
    public double getEstimatedAverageStepCount() {
        return 0;
    }

    @Override
    public boolean onlySaveFailingScreenshots() {
        return getEnvironmentVariables().getPropertyAsBoolean(ThucydidesSystemProperty.THUCYDIDES_ONLY_SAVE_FAILING_SCREENSHOTS.getPropertyName(), false);
    }

    @Override
    public void setDefaultBaseUrl(String defaultBaseUrl) {

    }

    @Override
    public int getRestartFrequency() {
        return 0;
    }

    @Override
    public int getCurrentTestCount() {
        return 0;
    }

    @Override
    public String getBaseUrl() {
        return null;
    }

    @Override
    public boolean takeVerboseScreenshots() {
        return getEnvironmentVariables().getPropertyAsBoolean(ThucydidesSystemProperty.THUCYDIDES_VERBOSE_SCREENSHOTS.getPropertyName(), false);
    }

    @Override
    public Optional<TakeScreenshots> getScreenshotLevel() {
        String takeScreenshotsLevel = THUCYDIDES_TAKE_SCREENSHOTS.from(getEnvironmentVariables());
        if (StringUtils.isNotEmpty(takeScreenshotsLevel)) {
            return Optional.of(TakeScreenshots.valueOf(takeScreenshotsLevel.toUpperCase()));
        } else {
            return Optional.absent();
        }
    }

    @Override
    public boolean storeHtmlSourceCode() {
        return getEnvironmentVariables().getPropertyAsBoolean(THUCYDIDES_STORE_HTML_SOURCE, false);
    }

    @Override
    public void setIfUndefined(String property, String value) {
        if (getEnvironmentVariables().getProperty(property) == null) {
            getEnvironmentVariables().setProperty(property, value);
        }
    }

    @Override
    public Configuration copy() {
        return withEnvironmentVariables(environmentVariables);
    }

    @Override
    public Configuration withEnvironmentVariables(EnvironmentVariables environmentVariables) {
        MyConfiguration copy = new MyConfiguration(environmentVariables.copy());
        copy.outputDirectory = null; // Reset to be reloaded from the System properties
        copy.defaultBaseUrl = defaultBaseUrl;
        return copy;
    }

    @Override
    public EnvironmentVariables getEnvironmentVariables() {
        return environmentVariables;
    }

    @Override
    public int maxRetries() {
        return 0;
    }
}
