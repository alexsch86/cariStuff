package org.learning.caristuff.domain.repository;

import org.learning.caristuff.domain.entities.DummyEntity;
import org.learning.caristuff.domain.jpa.JpaRepository;

import javax.inject.Named;

@Named
public class DummyEntityRepository extends JpaRepository<DummyEntity, Long> {

    private DummyEntityRepository() {
        super(DummyEntity.class);
    }

}