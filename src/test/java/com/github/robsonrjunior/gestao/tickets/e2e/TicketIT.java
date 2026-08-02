package com.github.robsonrjunior.gestao.tickets.e2e;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.robsonrjunior.gestao.tickets.e2e.pages.TicketFormPage;
import com.github.robsonrjunior.gestao.tickets.e2e.pages.TicketListPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketIT extends AbstractE2eIT {

    @BeforeEach
    void loginAdmin() {
        clearSession();
        loginAsAdmin();
    }

    @Test
    @DisplayName("Admin opens ticket list")
    void adminOpensTicketList() {
        TicketListPage list = goTo(TicketListPage.class);
        assertDisplayed(list.getTicketsTable());
    }

    @Test
    @DisplayName("Admin creates a ticket")
    void adminCreatesTicket() {
        String title = "e2e-ticket-create-" + System.currentTimeMillis();
        TicketListPage list = goTo(TicketListPage.class);
        list.openCreate();

        TicketFormPage form = onPage(TicketFormPage.class);
        form.fillTitle(title);
        form.fillDescription("created by e2e");
        form.selectPriority("HIGH");
        form.save();

        TicketListPage after = goTo(TicketListPage.class);
        after.filterGlobal(title);
        assertTrue(after.hasRowWithText(title), "Created ticket should appear in list");
    }

    @Test
    @DisplayName("Blank title shows validation")
    void titleValidation() {
        TicketListPage list = goTo(TicketListPage.class);
        list.openCreate();
        TicketFormPage form = onPage(TicketFormPage.class);
        form.fillDescription("no title");
        form.save();
        assertFalse(
            currentUrl().contains("ticket-list"),
            "Should not navigate to list when title is blank"
        );
    }

    @Test
    @DisplayName("Admin views and edits a ticket")
    void adminViewsAndEditsTicket() {
        String title = "e2e-ticket-edit-" + System.currentTimeMillis();
        String updated = title + "-updated";

        goTo(TicketListPage.class).openCreate();
        TicketFormPage form = onPage(TicketFormPage.class);
        form.fillTitle(title);
        form.fillDescription("to edit");
        form.save();

        TicketListPage list = goTo(TicketListPage.class);
        list.filterGlobal(title);
        list.openFirstView();

        form = onPage(TicketFormPage.class);
        assertTrue(form.getTitleValue().contains(title));
        form.edit();

        form = onPage(TicketFormPage.class);
        form.fillTitle(updated);
        form.save();

        list = goTo(TicketListPage.class);
        list.filterGlobal(updated);
        assertTrue(list.hasRowWithText(updated), "Updated title should appear in list");
    }

    @Test
    @DisplayName("Admin deletes a ticket")
    void adminDeletesTicket() {
        String title = "e2e-ticket-del-" + System.currentTimeMillis();

        goTo(TicketListPage.class).openCreate();
        TicketFormPage form = onPage(TicketFormPage.class);
        form.fillTitle(title);
        form.fillDescription("to delete");
        form.save();

        TicketListPage list = goTo(TicketListPage.class);
        list.filterGlobal(title);
        assertTrue(list.hasRowWithText(title));
        list.deleteFirstVisibleTicket();

        list = goTo(TicketListPage.class);
        list.filterGlobal(title);
        assertFalse(list.hasRowWithText(title), "Deleted ticket should not appear in list");
    }
}
