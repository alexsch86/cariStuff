package org.learning.caristuff;


import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.joda.time.DateTimeUtils.setCurrentMillisSystem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {InfrastructureConfigTest.class, ConfigEnvironmentTest.class})
public class InfrastructureIntegrationTest {

    @PersistenceContext
    protected EntityManager entityManager;

    @Before
    public void initDB() {
        setupData();
    }

    @After
    public void tearDown() {
        setCurrentMillisSystem();
    }

    protected void setupData() {
    }

}
