package reseller.tools;

import ch.lambdaj.Lambda;
import ch.lambdaj.function.convert.DefaultStringConverter;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.PropertiesUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by rusu on 6/18/15.
 */
public class MyEnvironmentVariables implements EnvironmentVariables {

    private Properties systemProperties;
    private Map<String, String> systemValues;

    public MyEnvironmentVariables() {
        this(System.getProperties(), System.getenv());
    }

    protected MyEnvironmentVariables(Properties systemProperties, Map<String, String> systemValues) {
        this.systemProperties = PropertiesUtil.copyOf(systemProperties);
        this.systemValues = new HashMap<String, String>(systemValues);
    }

    @Override
    public String getValue(String name) {
        return getValue(name, null);
    }

    @Override
    public String getValue(Enum<?> property) {
        return getValue(property.toString());
    }

    @Override
    public String getValue(String name, String defaultValue) {
        String value = systemValues.get(name);
        if (value == null) {
            return defaultValue;
        } else {
            return value;
        }
    }

    @Override
    public String getValue(Enum<?> property, String defaultValue) {
        return getValue(property.toString(), defaultValue);
    }

    @Override
    public Integer getPropertyAsInteger(String name, Integer defaultValue) {
        String value = (String) systemProperties.get(name);
        if (value != null) {
            return Integer.valueOf(value);
        } else {
            return defaultValue;
        }
    }

    @Override
    public Integer getPropertyAsInteger(Enum<?> property, Integer defaultValue) {
        return getPropertyAsInteger(property.toString(), defaultValue);
    }

    @Override
    public Boolean getPropertyAsBoolean(String name, boolean defaultValue) {
        if (getProperty(name) == null) {
            return defaultValue;
        } else if (StringUtils.isBlank(getProperty(name))) {
            return true;
        } else {
            return Boolean.parseBoolean(getProperty(name, "false"));
        }
    }

    @Override
    public Boolean getPropertyAsBoolean(Enum<?> property, boolean defaultValue) {
        return getPropertyAsBoolean(property.toString(), defaultValue);
    }

    @Override
    public String getProperty(String name) {
        return (String) systemProperties.get(name);
    }

    @Override
    public String getProperty(Enum<?> property) {
        return getProperty(property.toString());
    }

    @Override
    public String getProperty(String name, String defaultValue) {
        return systemProperties.getProperty(name, defaultValue);
    }

    @Override
    public String getProperty(Enum<?> property, String defaultValue) {
        return getProperty(property.toString(), defaultValue);
    }

    @Override
    public void setProperty(String name, String value) {
        systemProperties.setProperty(name, value);
    }

    @Override
    public void clearProperty(String name) {
        systemProperties.remove(name);
    }

    @Override
    public EnvironmentVariables copy() {
        return new MyEnvironmentVariables(systemProperties, systemValues);
    }

    @Override
    public List<String> getKeys() {
        return Lambda.convert(systemProperties.keySet(), new DefaultStringConverter());
    }
}
