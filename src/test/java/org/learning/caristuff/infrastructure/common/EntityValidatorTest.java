package org.learning.caristuff.infrastructure.common;

import org.junit.Ignore;
import org.junit.Test;
import org.learning.caristuff.domain.entities.DummyEntity;
import org.mockito.InjectMocks;

@Ignore
public class EntityValidatorTest extends UnitTest {

    @InjectMocks
    private EntityValidator validatorForDummyEntity;

    @Test
    public void validate_whenDummyEntityIsValid_doesNotThrowError() throws Exception {

    }


}