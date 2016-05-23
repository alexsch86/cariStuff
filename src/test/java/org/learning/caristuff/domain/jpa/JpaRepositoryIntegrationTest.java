package org.learning.caristuff.domain.jpa;

import org.junit.Test;
import org.learning.caristuff.InfrastructureIntegrationTest;
import org.learning.caristuff.domain.entities.DummyEntity;
import org.learning.caristuff.domain.entities.DummyEntityTestBuilder;
import org.learning.caristuff.domain.repository.DummyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.thymeleaf.util.DateUtils;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.util.Date;

import static org.fest.reflect.core.Reflection.field;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.learning.caristuff.domain.entities.DummyEntity.DummyEntityBuilder.dummyEntity;
import static org.learning.caristuff.domain.entities.DummyEntityTestBuilder.someDummyEntityTestBuilder;

@IntegrationTest
public class JpaRepositoryIntegrationTest extends InfrastructureIntegrationTest {

    private static final Integer SOME_INTEGER = 26;
    private static final String SOME_DESCRIPTION = "myDescription";
    private static final BigDecimal SOME_NUMBER = BigDecimal.valueOf(643);
    private static final Date SOME_DATE = DateUtils.create(2016, 5, 9).getTime();
    private static final String OTHER_DESCRIPTION = "anotherDescription";
    public static final int INTEGER_WITH_MORE_THAN_3_CHARACTERS = 3985;

    @Autowired
    private DummyEntityRepository dummyEntityRepository;

    private DummyEntity dummyEntity;

    @Override
    public void setupData() {
        dummyEntity = dummyEntity()
                .withDescription(SOME_DESCRIPTION)
                .withSomeInteger(SOME_INTEGER)
                .withSomeNumber(SOME_NUMBER)
                .withSomeDate(SOME_DATE)
                .build();

        dummyEntityRepository.save(dummyEntity);
    }

    @Test
    public void Save_FindById_savesAnEntityAndFindsIt() throws Exception {

        DummyEntity dummyEntityById = dummyEntityRepository.findById(dummyEntity.getId());

        assertEquals(SOME_INTEGER, dummyEntityById.getSomeInteger());
        assertEquals(SOME_DESCRIPTION, dummyEntityById.getDescription());
        assertEquals(SOME_NUMBER, dummyEntityById.getSomeNumber());
        assertEquals(SOME_DATE, dummyEntityById.getSomeDate());
    }

    @Test
    public void Merge_UpdatesEntity() throws Exception {
        field("description").ofType(String.class).in(dummyEntity).set(OTHER_DESCRIPTION);

        dummyEntityRepository.merge(dummyEntity);

        DummyEntity dummyEntityById = dummyEntityRepository.findById(dummyEntity.getId());
        assertEquals(SOME_INTEGER, dummyEntityById.getSomeInteger());
        assertEquals(OTHER_DESCRIPTION, dummyEntityById.getDescription());
        assertEquals(SOME_NUMBER, dummyEntityById.getSomeNumber());
        assertEquals(SOME_DATE, dummyEntityById.getSomeDate());
    }

    @Test
    public void Delete_RemovesTheEntity() throws Exception {
        dummyEntityRepository.delete(dummyEntity.getId());
        assertNull(dummyEntityRepository.findById(dummyEntity.getId()));
    }

    @Test(expected = ConstraintViolationException.class)
    public void Save_IntegerTooBig_ThrowsConstraintValidation() {
        DummyEntity someDummyEntity  = someDummyEntityTestBuilder()
                .withSomeInteger(8465)
                .build();

        dummyEntityRepository.save(someDummyEntity);
    }

}