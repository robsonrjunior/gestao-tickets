package com.github.robsonrjunior.gestao.tickets.e2e;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.robsonrjunior.gestao.tickets.e2e.config.E2eCredentials;
import com.github.robsonrjunior.gestao.tickets.e2e.pages.HomePage;
import com.github.robsonrjunior.gestao.tickets.e2e.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AuthIT extends AbstractE2eIT {

    @BeforeEach
    void resetSession() {
        clearSession();
    }

    @Test
    @DisplayName("Valid login redirects to home")
    void validLogin() {
        loginAsAdmin();
        assertTrue(currentUrl().contains("index.xhtml"), "Expected home after login, got: " + currentUrl());
        assertTrue(pageSourceContains("Gestão Tickets") || pageSourceContains("Gestao Tickets"));
    }

    @Test
    @DisplayName("Invalid login stays on login with error")
    void invalidLogin() {
        LoginPage loginPage = goTo(LoginPage.class);
        loginPage.login("admin", "wrong-password");
        assertTrue(currentUrl().contains("login"), "Expected login page, got: " + currentUrl());
        assertTrue(
            pageSourceContains("invalidos") || pageSourceContains("Erro") || pageSourceContains("invalid"),
            "Expected error message on invalid login"
        );
    }

    @Test
    @DisplayName("Logout ends session and shows login")
    void logout() {
        loginAsAdmin();
        HomePage home = goTo(HomePage.class);
        home.logout();
        assertTrue(currentUrl().contains("login"), "Expected login after logout, got: " + currentUrl());
    }

    @Test
    @DisplayName("Protected page without session redirects to login")
    void protectedRedirect() {
        clearSession();
        open("ticket-list.xhtml");
        assertTrue(
            currentUrl().contains("login"),
            "Expected redirect to login for protected page, got: " + currentUrl()
        );
        assertFalse(pageSourceContains("dt-tickets"));
    }

    @Test
    @DisplayName("Solicitante seed credentials work")
    void solicitanteLogin() {
        login(E2eCredentials.SOLICITANTE_USERNAME, E2eCredentials.SOLICITANTE_PASSWORD);
        assertTrue(currentUrl().contains("index.xhtml"), "Expected home after solicitante login");
    }
}
