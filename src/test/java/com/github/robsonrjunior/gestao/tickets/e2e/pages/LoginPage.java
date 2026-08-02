package com.github.robsonrjunior.gestao.tickets.e2e.pages;

import org.openqa.selenium.support.FindBy;
import org.primefaces.selenium.AbstractPrimePage;
import org.primefaces.selenium.PrimeSelenium;
import org.primefaces.selenium.component.CommandButton;
import org.primefaces.selenium.component.InputText;
import org.primefaces.selenium.component.Messages;
import org.primefaces.selenium.component.Password;

public class LoginPage extends AbstractPrimePage {

    @FindBy(id = "loginForm:username")
    private InputText username;

    @FindBy(id = "loginForm:password")
    private Password password;

    @FindBy(id = "loginForm:loginButton")
    private CommandButton loginButton;

    @FindBy(id = "loginForm:globalMsgs")
    private Messages messages;

    @Override
    public String getLocation() {
        return "login.xhtml";
    }

    public void login(String user, String pass) {
        username.setValue(user);
        password.setValue(pass);
        loginButton.click();
    }

    public Messages getMessages() {
        return messages;
    }

    public InputText getUsername() {
        return username;
    }

    public CommandButton getLoginButton() {
        return loginButton;
    }
}
