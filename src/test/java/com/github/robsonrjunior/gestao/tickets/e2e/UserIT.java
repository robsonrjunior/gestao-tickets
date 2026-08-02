package com.github.robsonrjunior.gestao.tickets.e2e;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.robsonrjunior.gestao.tickets.e2e.pages.UserFormPage;
import com.github.robsonrjunior.gestao.tickets.e2e.pages.UserListPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserIT extends AbstractE2eIT {

    @BeforeEach
    void loginAdmin() {
        clearSession();
        loginAsAdmin();
    }

    @Test
    @DisplayName("Admin opens user list")
    void adminOpensUserList() {
        UserListPage list = goTo(UserListPage.class);
        assertDisplayed(list.getUsersTable());
    }

    @Test
    @DisplayName("Admin creates a user")
    void adminCreatesUser() {
        long ts = System.currentTimeMillis();
        String username = "e2euser" + ts;
        String email = username + "@example.com";

        goTo(UserListPage.class).openCreate();
        UserFormPage form = onPage(UserFormPage.class);
        form.fillCreate(username, email, "E2E User", "pass12345", "Solicitante");
        form.save();

        UserListPage list = goTo(UserListPage.class);
        list.filterGlobal(username);
        assertTrue(list.hasRowWithText(username), "Created user should appear in list");
    }

    @Test
    @DisplayName("Admin views and edits a user")
    void adminViewsAndEditsUser() {
        long ts = System.currentTimeMillis();
        String username = "e2eedit" + ts;
        String email = username + "@example.com";
        String updatedName = "E2E Updated " + ts;

        goTo(UserListPage.class).openCreate();
        UserFormPage form = onPage(UserFormPage.class);
        form.fillCreate(username, email, "E2E Before", "pass12345", "Solicitante");
        form.save();

        UserListPage list = goTo(UserListPage.class);
        list.filterGlobal(username);
        list.openFirstView();

        form = onPage(UserFormPage.class);
        assertTrue(form.getUsernameValue().contains(username));
        form.edit();

        form = onPage(UserFormPage.class);
        form.fillDisplayName(updatedName);
        form.save();

        list = goTo(UserListPage.class);
        list.filterGlobal(username);
        assertTrue(list.hasRowWithText(updatedName), "Updated display name should appear in list");
    }
}
