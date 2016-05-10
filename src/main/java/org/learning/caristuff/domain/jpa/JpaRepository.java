package org.learning.caristuff.domain.jpa;

import org.springframework.orm.jpa.JpaOptimisticLockingFailureException;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

public class JpaRepository<ENTITY extends JpaAggregateRoot<ENTITY, ID>, ID> implements Repository<ENTITY, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected final Class<ENTITY> clazz;

    public JpaRepository(Class<ENTITY> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void save(ENTITY entity) {
        try {
            entityManager.persist(entity);
            entityManager.lock(entity, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        } catch (JpaOptimisticLockingFailureException e) {
            throw new RuntimeException("MESSAGE.CONCURRENT_MODIFICATION", e);
        }
    }

    @Override
    public ENTITY findById(ID id) {
        if(id == null) {
            return null;
        }

        return entityManager.find(clazz, id);
    }

    public ENTITY merge(ENTITY entity) {
        return null;
    }

    public void delete(ID id) {

    }


}
