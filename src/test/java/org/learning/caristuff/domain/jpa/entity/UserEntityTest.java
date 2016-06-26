package org.learning.caristuff.domain.jpa.entity;

import org.joda.time.DateTime;
import org.junit.Test;
import org.learning.caristuff.InfrastructureIntegrationTest;
import org.learning.caristuff.domain.entities.DummyEntity;
import org.learning.caristuff.domain.entities.User;
import org.learning.caristuff.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;


import java.util.Date;

import static org.fest.reflect.core.Reflection.field;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by kinks on 5/12/2016.
 */
@IntegrationTest
public class UserEntityTest extends InfrastructureIntegrationTest {

    private static final Integer RATING = 0;
    private static final String CARD_NUMBER = "123456789";
    private static final String FIRST_NAME = "Test";
    private static final String LAST_NAME = "User";
    private static final String IDENTIFIER = "09876543212";
    private static final String PHONE_NUMBER = "0764123123";
    private static final Date DATE = new DateTime(2016, 5, 9, 0, 0).toDate();
    private static final String OTHER_FIRST_NAME = "Otherz";


    @Autowired
    private UserRepository userRepository;

    private User testUser;

    @Override
    protected void setupData() {
        testUser = User.UserBuilder.user()
                .withBirthDate(DATE)
                .withCardNumber(CARD_NUMBER)
                .withFirstName(FIRST_NAME)
                .withLastName(LAST_NAME)
                .withIdentifier(IDENTIFIER)
                .withPhoneNumber(PHONE_NUMBER)
                .build();

        userRepository.save(testUser);
    }

    @Test
    public void createUser(){
        User dummyEntityById = userRepository.findById(testUser.getId());

        assertEquals(CARD_NUMBER, dummyEntityById.getCardNumber());
        assertEquals(FIRST_NAME, dummyEntityById.getFirstName());
        assertEquals(LAST_NAME, dummyEntityById.getLastName());
        assertEquals(IDENTIFIER, dummyEntityById.getIdentifier());
        assertEquals(RATING, dummyEntityById.getRating());
    }

    @Test
    public void Merge_UpdatesEntity() throws Exception {
        field("firstName").ofType(String.class).in(testUser).set(OTHER_FIRST_NAME);

        userRepository.merge(testUser);

        User dummyEntityById = userRepository.findById(testUser.getId());

        assertEquals(CARD_NUMBER, dummyEntityById.getCardNumber());
        assertEquals(OTHER_FIRST_NAME, dummyEntityById.getFirstName());
        assertEquals(LAST_NAME, dummyEntityById.getLastName());
        assertEquals(IDENTIFIER, dummyEntityById.getIdentifier());
        assertEquals(RATING, dummyEntityById.getRating());
    }

    @Test
    public void Delete_RemovesTheEntity() throws Exception {
        userRepository.delete(testUser.getId());
        assertNull(userRepository.findById(testUser.getId()));
    }
}
