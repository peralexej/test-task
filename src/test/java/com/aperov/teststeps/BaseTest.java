package com.aperov.teststeps;

import com.aperov.conf.ConfigProperties;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


/**
 * Copyright (c) 2023.
 * Base test class
 * All other test classes has to be extended by this class
 *
 * @author Aleksei Perov
 * @version 1.0
 * @since 1.0
 */

public abstract class BaseTest {
    private static final ConfigProperties CONFIG_PROPERTIES = ConfigProperties.getInstance();

    private String resolution = "fullScreen";

    //in case you want to run a browser in another resolution
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @BeforeClass
    protected void setup() {
        System.setProperty("-Dorg.slf4j.simpleLogger.defaultLogLevel", "debug");
        Configuration.timeout = CONFIG_PROPERTIES.getMaxWaitTime();
        ChromeOptions options = new ChromeOptions();
        if (resolution.equalsIgnoreCase("fullScreen")) {
            options.addArguments("start-maximized");
            Configuration.browserSize = null;
        } else {
            Configuration.browserSize = resolution;
        }
        Configuration.browserCapabilities = options;
        Configuration.reportsFolder = "target/results";
        Configuration.browser = CONFIG_PROPERTIES.getDriverType();
        Configuration.baseUrl = CONFIG_PROPERTIES.getUIEnvAddress();
        Configuration.downloadsFolder = "target/downloads";
        Configuration.pageLoadTimeout = CONFIG_PROPERTIES.getMaxWaitTime();
    }

    @AfterMethod
    public void tearDown() {
        Selenide.clearBrowserCookies();
    }

    @AfterClass
    public void endUp() {
        Selenide.closeWebDriver();
    }
}