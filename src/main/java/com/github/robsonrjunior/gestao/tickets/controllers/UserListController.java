package com.github.robsonrjunior.gestao.tickets.controllers;

import com.github.robsonrjunior.gestao.tickets.dto.UserListItem;
import com.github.robsonrjunior.gestao.tickets.service.UserService;
import com.github.robsonrjunior.gestao.tickets.views.UserLazyDataModel;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.security.RolesAllowed;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
@RolesAllowed("ADMIN")
public class UserListController implements Serializable {

    @Inject
    private UserService userService;

    private UserLazyDataModel lazyUsers;
    private List<UserListItem> selectedUsers;
    private UserListItem selectedUser;

    @PostConstruct
    public void init() {
        lazyUsers = new UserLazyDataModel(userService);
    }

    public UserLazyDataModel getLazyUsers() {
        return lazyUsers;
    }

    public List<UserListItem> getSelectedUsers() {
        return selectedUsers;
    }

    public void setSelectedUsers(List<UserListItem> selectedUsers) {
        this.selectedUsers = selectedUsers;
    }

    public UserListItem getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(UserListItem selectedUser) {
        this.selectedUser = selectedUser;
    }

    public void deleteUser() {
        if (selectedUser != null && selectedUser.id() != null) {
            userService.delete(selectedUser.id());
            addMessage(FacesMessage.SEVERITY_INFO, "Usuario excluido", "Usuario removido com sucesso.");
        }
    }

    public void deleteSelectedUsers() {
        if (hasSelectedUsers()) {
            for (UserListItem user : new ArrayList<>(selectedUsers)) {
                userService.delete(user.id());
            }
            selectedUsers = null;
            addMessage(FacesMessage.SEVERITY_INFO, "Usuarios excluidos", "Usuarios selecionados removidos com sucesso.");
        }
    }

    public boolean hasSelectedUsers() {
        return selectedUsers != null && !selectedUsers.isEmpty();
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedUsers()) {
            int size = selectedUsers.size();
            return size > 1 ? size + " usuarios selecionados" : "1 usuario selecionado";
        }
        return "Excluir";
    }

    private void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }
}
