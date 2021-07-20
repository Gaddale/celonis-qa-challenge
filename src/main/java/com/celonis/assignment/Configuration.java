package com.celonis.assignment;

import static java.lang.System.getenv;

// Set As system property or env variable
public enum Configuration {
    BROWSER("BROWSER", "chrome"),
    TEST_ENV("URL", "https://applications.eu-1.celonis.cloud/ui/login"),
    OS("OS","linux"),
    IMPLICIT_WAIT("WAIT_TIME", "5"),
    TEST_USER("user","gaddale.nagaraja@gmail.com"),
    PASSWORD("password","Try@0nce"),
    INVALID_USER("invalid_user", "abc@gmail.com");

    private final String value;

    Configuration(String mode, String defaultValue) {
        if (getenv(mode) != null)
            this.value = getenv(mode);
        else
            this.value = defaultValue;
    }

    public String getValue() {
        return this.value;
    }
}
