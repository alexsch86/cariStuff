package org.learning.caristuff.domain.jpa;

import org.junit.Test;
import org.learning.caristuff.InfrastructureIntegrationTest;
import org.learning.caristuff.domain.entities.DummyEntity;
import org.learning.caristuff.domain.repository.DummyEntityRepository;
import org.springframework.boot.test.IntegrationTest;
import org.thymeleaf.util.DateUtils;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.learning.caristuff.domain.entities.DummyEntity.DummyEntityBuilder.dummyEntity;

@IntegrationTest
public class JpaRepositoryIntegrationTest extends InfrastructureIntegrationTest {

    private static final Integer MY_INTEGER = 26;
    private static final String MY_DESCRIPTION = "myDescription";
    private static final BigDecimal MY_NUMBER = BigDecimal.valueOf(643);
    private static final Date SOME_DATE = DateUtils.create(2016, 5, 9).getTime();

    @Inject
    private DummyEntityRepository dummyEntityRepository;

    private DummyEntity dummyEntity;

    @Override
    public void setupData() {
        dummyEntity = dummyEntity()
                .withDescription(MY_DESCRIPTION)
                .withSomeInteger(MY_INTEGER)
                .withSomeNumber(MY_NUMBER)
                .withSomeDate(SOME_DATE)
                .build();
    }

    @Test
    public void Save_FindById_savesAnEntityAndFindsIt() throws Exception {

        dummyEntityRepository.save(dummyEntity);

        DummyEntity dummyEntityById = dummyEntityRepository.findById(dummyEntity.getId());

        assertEquals(dummyEntity.getSomeInteger(), dummyEntityById.getSomeInteger());
        assertEquals(dummyEntity.getDescription(), dummyEntityById.getDescription());
        assertEquals(dummyEntity.getSomeNumber(), dummyEntityById.getSomeNumber());
        assertEquals(dummyEntity.getSomeDate(), dummyEntityById.getSomeDate());
    }

    public void Merge_UpdatesEntity() throws Exception {

    }

    public void Delete_RemovesTheEntity() throws Exception {

    }

}