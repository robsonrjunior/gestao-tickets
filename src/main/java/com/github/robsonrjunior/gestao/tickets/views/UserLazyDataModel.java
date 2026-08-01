package com.github.robsonrjunior.gestao.tickets.views;

import com.github.robsonrjunior.gestao.tickets.dto.UserListItem;
import com.github.robsonrjunior.gestao.tickets.repository.Page;
import com.github.robsonrjunior.gestao.tickets.service.UserService;
import java.util.List;
import java.util.Map;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

public class UserLazyDataModel extends LazyDataModel<UserListItem> {

    private final UserService userService;
    private List<UserListItem> currentPage = List.of();

    public UserLazyDataModel(UserService userService) {
        this.userService = userService;
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        return (int) userService.findPage(0, 0, null, filterBy).totalElements();
    }

    @Override
    public List<UserListItem> load(
        int first,
        int pageSize,
        Map<String, SortMeta> sortBy,
        Map<String, FilterMeta> filterBy
    ) {
        Page<UserListItem> page = userService.findPage(first, pageSize, sortBy, filterBy);
        setRowCount((int) page.totalElements());
        currentPage = page.content();
        return currentPage;
    }

    @Override
    public String getRowKey(UserListItem user) {
        return user == null || user.id() == null ? null : String.valueOf(user.id());
    }

    @Override
    public UserListItem getRowData(String rowKey) {
        if (rowKey == null || rowKey.isBlank()) {
            return null;
        }
        Long id = Long.valueOf(rowKey);
        return currentPage
            .stream()
            .filter(item -> id.equals(item.id()))
            .findFirst()
            .orElseGet(() -> new UserListItem(id, null, null, null, null, null));
    }
}
