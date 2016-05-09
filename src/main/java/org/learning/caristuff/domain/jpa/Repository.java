package org.learning.caristuff.domain.jpa;

public interface Repository<ENTITY extends BaseEntity<ENTITY, ID>, ID> {

    public void save(ENTITY entity);

    public ENTITY findById(ID id);

}
