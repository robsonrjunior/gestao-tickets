package com.github.robsonrjunior.gestao.tickets.e2e.pages;

import org.openqa.selenium.support.FindBy;
import org.primefaces.selenium.AbstractPrimePage;
import org.primefaces.selenium.PrimeSelenium;
import org.primefaces.selenium.component.Button;
import org.primefaces.selenium.component.CommandButton;
import org.primefaces.selenium.component.InputText;
import org.primefaces.selenium.component.InputTextarea;
import org.primefaces.selenium.component.Message;
import org.primefaces.selenium.component.SelectOneMenu;

public class TicketFormPage extends AbstractPrimePage {

    @FindBy(id = "ticketForm:title")
    private InputText title;

    @FindBy(id = "ticketForm:description")
    private InputTextarea description;

    @FindBy(id = "ticketForm:priority")
    private SelectOneMenu priority;

    @FindBy(id = "ticketForm:titleMsg")
    private Message titleMsg;

    @FindBy(id = "ticketForm:saveButton")
    private CommandButton saveButton;

    @FindBy(id = "ticketForm:cancelButton")
    private Button cancelButton;

    @FindBy(id = "ticketForm:editButton")
    private Button editButton;

    @FindBy(id = "ticketForm:backButton")
    private Button backButton;

    @Override
    public String getLocation() {
        return "ticket.xhtml";
    }

    public void fillTitle(String value) {
        title.setValue(value);
    }

    public void fillDescription(String value) {
        description.setValue(value);
    }

    public void selectPriority(String label) {
        priority.select(label);
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

    public String getTitleValue() {
        return title.getValue();
    }

    public Message getTitleMsg() {
        return titleMsg;
    }

    public CommandButton getSaveButton() {
        return saveButton;
    }

    public Button getEditButton() {
        return editButton;
    }

    public InputText getTitle() {
        return title;
    }
}
