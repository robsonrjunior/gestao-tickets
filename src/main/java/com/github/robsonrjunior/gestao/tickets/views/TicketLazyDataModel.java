package com.github.robsonrjunior.gestao.tickets.views;

import com.github.robsonrjunior.gestao.tickets.dto.TicketListItem;
import com.github.robsonrjunior.gestao.tickets.repository.Page;
import com.github.robsonrjunior.gestao.tickets.service.TicketService;
import java.util.List;
import java.util.Map;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

public class TicketLazyDataModel extends LazyDataModel<TicketListItem> {

    private final TicketService ticketService;
    private List<TicketListItem> currentPage = List.of();

    public TicketLazyDataModel(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        return (int) ticketService.findPage(0, 0, null, filterBy).totalElements();
    }

    @Override
    public List<TicketListItem> load(
        int first,
        int pageSize,
        Map<String, SortMeta> sortBy,
        Map<String, FilterMeta> filterBy
    ) {
        Page<TicketListItem> page = ticketService.findPage(first, pageSize, sortBy, filterBy);
        setRowCount((int) page.totalElements());
        currentPage = page.content();
        return currentPage;
    }

    @Override
    public String getRowKey(TicketListItem ticket) {
        return ticket == null || ticket.id() == null ? null : String.valueOf(ticket.id());
    }

    @Override
    public TicketListItem getRowData(String rowKey) {
        if (rowKey == null || rowKey.isBlank()) {
            return null;
        }
        Long id = Long.valueOf(rowKey);
        return currentPage
            .stream()
            .filter(item -> id.equals(item.id()))
            .findFirst()
            .orElse(null);
    }
}
