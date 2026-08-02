package com.github.robsonrjunior.gestao.tickets.e2e.pages;

import org.openqa.selenium.support.FindBy;
import org.primefaces.selenium.AbstractPrimePage;
import org.primefaces.selenium.PrimeSelenium;
import org.primefaces.selenium.component.Button;
import org.primefaces.selenium.component.CommandButton;
import org.primefaces.selenium.component.InputText;
import org.primefaces.selenium.component.Password;
import org.primefaces.selenium.component.SelectOneMenu;

public class UserFormPage extends AbstractPrimePage {

    @FindBy(id = "userForm:username")
    private InputText username;

    @FindBy(id = "userForm:email")
    private InputText email;

    @FindBy(id = "userForm:displayName")
    private InputText displayName;

    @FindBy(id = "userForm:password")
    private Password password;

    @FindBy(id = "userForm:role")
    private SelectOneMenu role;

    @FindBy(id = "userForm:roleEdit")
    private SelectOneMenu roleEdit;

    @FindBy(id = "userForm:saveButton")
    private CommandButton saveButton;

    @FindBy(id = "userForm:editButton")
    private Button editButton;

    @FindBy(id = "userForm:backButton")
    private Button backButton;

    @Override
    public String getLocation() {
        return "user.xhtml";
    }

    public void fillCreate(String user, String mail, String name, String pass, String roleLabel) {
        username.setValue(user);
        email.setValue(mail);
        displayName.setValue(name);
        password.setValue(pass);
        role.select(roleLabel);
    }

    public void fillDisplayName(String name) {
        displayName.setValue(name);
    }

    public void save() {
        saveButton.click();
    }

    public void edit() {
        PrimeSelenium.guardHttp(editButton).click();
    }

    public void back() {
        PrimeSelenium.guardHttp(backButton).click();
    }

    public String getUsernameValue() {
        return username.getValue();
    }

    public String getDisplayNameValue() {
        return displayName.getValue();
    }

    public InputText getUsername() {
        return username;
    }

    public Button getEditButton() {
        return editButton;
    }
}
