package com.jeison.library.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

import com.jeison.library.utils.enums.SortType;

public interface CrudServiceFindAll<RQ, RS, ID> {

    public Page<RS> findAll(int page, int size, SortType sortType);

}
