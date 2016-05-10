package org.learning.caristuff;


import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.joda.time.DateTimeUtils.setCurrentMillisSystem;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {InfrastructureConfigTest.class, ConfigEnvironmentTest.class})
@Transactional
public class InfrastructureIntegrationTest extends AbstractJUnit4SpringContextTests {

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
