package org.learning.caristuff.services;

import org.learning.caristuff.domain.entities.DummyEntity;
import org.learning.caristuff.domain.repository.DummyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by alexands on 15.06.2016.
 */
@Service
public class DummyEntityService {

    @Autowired
    private DummyEntityRepository dummyEntityRepository;

    public Optional<DummyEntity> getDummyEntityById(Long id) {
        DummyEntity dummyEntity = dummyEntityRepository.findById(id);
        return Optional.of(dummyEntity);
    }
    
}
