package org.learning.caristuff.rest;

import org.learning.caristuff.domain.entities.DummyEntity;
import org.learning.caristuff.services.DummyEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by alexands on 15.06.2016.
 */
@RestController
@RequestMapping("/dummyEntity")
public class DummyEntityResource {

    @Autowired
    private DummyEntityService dummyEntityService;

    @RequestMapping("/getDummy")
    public Optional<DummyEntity> getDummyEntity(@RequestParam(value = "id") Long idDummyEntity) {
        return dummyEntityService.getDummyEntityById(idDummyEntity);
    }
    
}
