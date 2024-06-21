package com.jeison.library.infrastructure.abstract_services;

public interface CrudService<RQ, UPDATE, RS, ID> {

    public RS findById(ID id);

    public RS create(RQ request);

    public RS update(UPDATE request, ID id);

    public void delete(ID id);
}
