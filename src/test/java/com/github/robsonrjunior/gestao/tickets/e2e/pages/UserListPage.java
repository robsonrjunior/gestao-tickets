package com.github.robsonrjunior.gestao.tickets.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.primefaces.selenium.AbstractPrimePage;
import org.primefaces.selenium.PrimeSelenium;
import org.primefaces.selenium.component.Button;
import org.primefaces.selenium.component.DataTable;
import org.primefaces.selenium.component.InputText;

public class UserListPage extends AbstractPrimePage {

    @FindBy(id = "userForm:dt-users")
    private DataTable usersTable;

    @FindBy(id = "userForm:newUserButton")
    private Button newUserButton;

    @FindBy(id = "userForm:globalFilter")
    private InputText globalFilter;

    @Override
    public String getLocation() {
        return "user-list.xhtml";
    }

    public DataTable getUsersTable() {
        return usersTable;
    }

    public void openCreate() {
        PrimeSelenium.guardHttp(newUserButton).click();
    }

    public void filterGlobal(String text) {
        PrimeSelenium.executeScript(
            "var el = document.getElementById('userForm:globalFilter');" +
            "el.value = arguments[0];" +
            "el.dispatchEvent(new Event('input', {bubbles:true}));" +
            "PF('dtUsers').filter();",
            text
        );
        PrimeSelenium.wait(1000);
    }

    public boolean hasRowWithText(String text) {
        PrimeSelenium.wait(500);
        return getWebDriver().getPageSource().contains(text);
    }

    public void openFirstView() {
        WebElement view = getWebDriver().findElement(By.cssSelector("a[id$='viewUserButton']"));
        PrimeSelenium.guardHttp(view).click();
    }

    public void openViewByUsername(String username) {
        filterGlobal(username);
        openFirstView();
    }

    public Button getNewUserButton() {
        return newUserButton;
    }
}
