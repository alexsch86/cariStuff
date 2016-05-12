package org.learning.caristuff.domain.repository;

import org.learning.caristuff.domain.entities.DummyEntity;
import org.learning.caristuff.domain.jpa.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DummyEntityRepository extends JpaRepository<DummyEntity, Long> {

     public DummyEntityRepository() {
        super(DummyEntity.class);
    }

}
