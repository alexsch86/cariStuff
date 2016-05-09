package org.learning.caristuff.domain.jpa;

public class JpaRepository<ENTITY extends JpaAggregateRoot<ENTITY, ID>, ID> implements Repository<ENTITY, ID> {


    protected final Class<ENTITY> clazz;

    public JpaRepository(Class<ENTITY> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void save(ENTITY entity) {

    }

    @Override
    public ENTITY findById(ID id) {
        return null;
    }

    public ENTITY merge(ENTITY entity) {
        return null;
    }

    public void delete(ID id) {

    }


}
