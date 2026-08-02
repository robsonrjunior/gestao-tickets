package com.github.robsonrjunior.gestao.tickets.e2e.config;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.primefaces.selenium.internal.ConfigProvider;
import org.primefaces.selenium.spi.WebDriverAdapter;

/**
 * Chrome WebDriver for local e2e. Prefers Chrome for Testing under {@code .tools/}
 * or {@code CHROME_BIN} / {@code chrome.binary}.
 */
public class E2eWebDriverAdapter implements WebDriverAdapter {

    @Override
    public void initialize(ConfigProvider configProvider) {
        // WebDriverManager / Selenium Manager resolve chromedriver
    }

    @Override
    public WebDriver createWebDriver() {
        ConfigProvider config = ConfigProvider.getInstance();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        String binary = resolveChromeBinary();
        if (binary != null) {
            options.setBinary(binary);
        }

        if (config.isWebdriverHeadless()) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, config.getWebdriverLogLevel() != null
            ? config.getWebdriverLogLevel()
            : Level.WARNING);
        options.setCapability(ChromeOptions.LOGGING_PREFS, logPrefs);

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.default_directory", System.getProperty("java.io.tmpdir"));
        options.setExperimentalOption("prefs", prefs);

        return new ChromeDriver(options);
    }

    static String resolveChromeBinary() {
        String fromProp = System.getProperty("chrome.binary");
        if (isExecutable(fromProp)) {
            return fromProp;
        }
        String fromEnv = System.getenv("CHROME_BIN");
        if (isExecutable(fromEnv)) {
            return fromEnv;
        }
        Path projectChrome = Path.of(System.getProperty("user.dir"), ".tools", "chrome-linux64", "chrome");
        if (Files.isExecutable(projectChrome)) {
            return projectChrome.toAbsolutePath().toString();
        }
        return null;
    }

    private static boolean isExecutable(String path) {
        return path != null && !path.isBlank() && Files.isExecutable(Path.of(path));
    }
}
