package com.github.robsonrjunior.gestao.tickets.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.primefaces.selenium.AbstractPrimePage;
import org.primefaces.selenium.PrimeSelenium;
import org.primefaces.selenium.component.Button;
import org.primefaces.selenium.component.CommandButton;
import org.primefaces.selenium.component.DataTable;
import org.primefaces.selenium.component.InputText;

public class TicketListPage extends AbstractPrimePage {

    @FindBy(id = "ticketForm:dt-tickets")
    private DataTable ticketsTable;

    @FindBy(id = "ticketForm:newTicketButton")
    private Button newTicketButton;

    @FindBy(id = "ticketForm:globalFilter")
    private InputText globalFilter;

    @FindBy(id = "ticketForm:confirmDeleteTicketYes")
    private CommandButton confirmDeleteYes;

    @Override
    public String getLocation() {
        return "ticket-list.xhtml";
    }

    public DataTable getTicketsTable() {
        return ticketsTable;
    }

    public void openCreate() {
        PrimeSelenium.guardHttp(newTicketButton).click();
    }

    public void filterGlobal(String text) {
        PrimeSelenium.executeScript(
            "var el = document.getElementById('ticketForm:globalFilter');" +
            "el.value = arguments[0];" +
            "el.dispatchEvent(new Event('input', {bubbles:true}));" +
            "PF('dtTickets').filter();",
            text
        );
        PrimeSelenium.wait(1000);
    }

    public boolean hasRowWithText(String text) {
        PrimeSelenium.wait(500);
        return getWebDriver().getPageSource().contains(text);
    }

    public void openFirstView() {
        WebElement view = getWebDriver().findElement(By.cssSelector("a[id$='viewTicketButton']"));
        PrimeSelenium.guardHttp(view).click();
    }

    public void openViewByTitle(String title) {
        filterGlobal(title);
        openFirstView();
    }

    public void deleteFirstVisibleTicket() {
        WebElement delete = ticketsTable.findElement(By.cssSelector("button[id$='deleteTicketButton']"));
        PrimeSelenium.guardAjax(delete).click();
        confirmDeleteYes.click();
        PrimeSelenium.wait(500);
    }

    public Button getNewTicketButton() {
        return newTicketButton;
    }
}
