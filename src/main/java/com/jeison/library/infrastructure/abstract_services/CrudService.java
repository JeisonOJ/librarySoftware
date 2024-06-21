package com.jeison.library.infrastructure.abstract_services;

public interface CrudService<RQ, UPDATE, RS, RSDETAILED, ID> {

    public RSDETAILED findById(ID id);

    public RS create(RQ request);

    public RS update(UPDATE request, ID id);

    public void delete(ID id);
}
