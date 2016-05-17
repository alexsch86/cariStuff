package org.learning.caristuff.infrastructure.common;

import org.junit.Test;
import org.learning.caristuff.domain.entities.DummyEntity;
import org.mockito.InjectMocks;

public class EntityValidatorTest extends UnitTest {

    @InjectMocks
    private EntityValidator<DummyEntity> validatorForDummyEntity;

    @Test
    public void validate_whenDummyEntityIsValid_doesNotThrowError() throws Exception {

    }


}