package org.learning.caristuff.domain.jpa;

import org.learning.caristuff.infrastructure.common.EntityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaOptimisticLockingFailureException;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

public class JpaRepository<ENTITY extends JpaAggregateRoot<ENTITY, ID>, ID> implements Repository<ENTITY, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected final Class<ENTITY> clazz;

    @Autowired
    private EntityValidator entityValidator;

    public JpaRepository(Class<ENTITY> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void save(ENTITY entity) {
        try {
            entityValidator.validate(entity, null);
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
        try {
            entityValidator.validate(entity, null);
            ENTITY merge = entityManager.merge(entity);
            entityManager.lock(merge, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
            return merge;
        } catch (JpaOptimisticLockingFailureException e) {
            throw new RuntimeException("MESSAGE.CONCURRENT_MODIFICATION", e);
        }
    }

    public void delete(ID id) {
        ENTITY entity = id == null ? null : findById(id);

        if(entity != null) {
            entityManager.remove(entity);
        }
    }

}
