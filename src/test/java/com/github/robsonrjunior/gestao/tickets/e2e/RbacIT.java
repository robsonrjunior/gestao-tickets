package com.github.robsonrjunior.gestao.tickets.e2e;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.robsonrjunior.gestao.tickets.e2e.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RbacIT extends AbstractE2eIT {

    @BeforeEach
    void reset() {
        clearSession();
    }

    @Test
    @DisplayName("Solicitante navigation shows Meus Tickets, not Usuarios")
    void solicitanteNavigation() {
        loginAsSolicitante();
        goTo(HomePage.class);
        assertTrue(pageSourceContains("Meus Tickets"), "Solicitante should see Meus Tickets");
        assertFalse(
            pageSourceContains("outcome=\"user-list\"") || pageSourceContains("user-list.xhtml"),
            "Solicitante should not have Usuarios menu link"
        );
        // menu label Usuarios is inside admin submenu only
        String source = getWebDriver().getPageSource();
        boolean hasUsuariosMenu =
            source.contains(">Usuarios<") || source.contains(">Usuários<");
        assertFalse(hasUsuariosMenu, "Solicitante must not see Usuarios menu");
    }

    @Test
    @DisplayName("Non-admin denied user-list page")
    void nonAdminDeniedUserPages() {
        loginAsSolicitante();
        open("user-list.xhtml");
        String url = currentUrl();
        String source = getWebDriver().getPageSource();
        boolean denied =
            url.contains("login")
                || source.contains("403")
                || source.contains("Forbidden")
                || source.contains("Access Denied")
                || source.contains("HTTP Status 403")
                || source.contains("não autorizado")
                || source.contains("not authorized")
                || !source.contains("dt-users");
        assertTrue(denied, "Non-admin must not access user list. URL=" + url);
        assertFalse(source.contains("id=\"userForm:dt-users\""), "User table must not render for non-admin");
    }

    @Test
    @DisplayName("Admin sees tickets and users navigation")
    void adminFullNavigation() {
        loginAsAdmin();
        goTo(HomePage.class);
        assertTrue(
            pageSourceContains("Tickets") || pageSourceContains("ticket-list"),
            "Admin should see tickets nav"
        );
        assertTrue(
            pageSourceContains("Administracao") || pageSourceContains("Administração") || pageSourceContains("Usuarios") || pageSourceContains("user-list"),
            "Admin should see users nav"
        );
    }
}
