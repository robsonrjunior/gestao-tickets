package com.github.robsonrjunior.gestao.tickets.e2e;

import com.github.robsonrjunior.gestao.tickets.e2e.config.E2eCredentials;
import com.github.robsonrjunior.gestao.tickets.e2e.pages.LoginPage;
import org.primefaces.selenium.AbstractPrimePage;
import org.primefaces.selenium.AbstractPrimePageTest;
import org.primefaces.selenium.PrimeSelenium;
import org.primefaces.selenium.spi.PrimePageFactory;

public abstract class AbstractE2eIT extends AbstractPrimePageTest {

    protected void loginAsAdmin() {
        login(E2eCredentials.ADMIN_USERNAME, E2eCredentials.ADMIN_PASSWORD);
    }

    protected void loginAsSolicitante() {
        login(E2eCredentials.SOLICITANTE_USERNAME, E2eCredentials.SOLICITANTE_PASSWORD);
    }

    protected void login(String username, String password) {
        LoginPage loginPage = goTo(LoginPage.class);
        loginPage.login(username, password);
    }

    protected void clearSession() {
        getWebDriver().manage().deleteAllCookies();
    }

    protected String currentUrl() {
        return getWebDriver().getCurrentUrl();
    }

    protected boolean pageSourceContains(String text) {
        return getWebDriver().getPageSource().contains(text);
    }

    protected void open(String relativePath) {
        String path = relativePath.startsWith("/") ? relativePath.substring(1) : relativePath;
        PrimeSelenium.goTo(path);
    }

    protected <T extends AbstractPrimePage> T onPage(Class<T> pageClass) {
        return PrimePageFactory.create(pageClass, getWebDriver());
    }
}
