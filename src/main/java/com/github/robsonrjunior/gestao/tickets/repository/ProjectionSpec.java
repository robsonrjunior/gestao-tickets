package com.github.robsonrjunior.gestao.tickets.repository;

import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;
import java.util.List;
import java.util.Set;

public interface ProjectionSpec<T, D> {
    Class<D> projectionType();

    List<Selection<?>> selections(Root<T> root);

    Set<String> filterableFields();

    Set<String> sortableFields();

    Set<String> globalFilterFields();
}
