package com.github.robsonrjunior.gestao.tickets.e2e.pages;

import org.openqa.selenium.support.FindBy;
import org.primefaces.selenium.AbstractPrimePage;
import org.primefaces.selenium.PrimeSelenium;
import org.primefaces.selenium.component.CommandButton;

public class HomePage extends AbstractPrimePage {

    @FindBy(id = "logoutForm:logoutButton")
    private CommandButton logoutButton;

    @Override
    public String getLocation() {
        return "index.xhtml";
    }

    public void logout() {
        logoutButton.click();
    }

    public CommandButton getLogoutButton() {
        return logoutButton;
    }
}
