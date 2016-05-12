package org.learning.caristuff.domain.entities;

import org.learning.caristuff.common.Builder;
import org.learning.caristuff.domain.jpa.JpaAggregateRoot;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kinks on 5/12/2016.
 */
@Entity
@Table(name = User.USER_ENTITY_TABLE_NAME)
public class User extends JpaAggregateRoot<User, Long> {

    static final String USER_ENTITY_TABLE_NAME = "user";

    @Id
    @Column(nullable = false, name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(nullable = false, name = "birth_date")
    private Date birthDate;

    @Column(nullable = false, name = "rating")
    private Integer rating;

    public User() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public Long getId() {
        return id;
    }

    public static class UserBuilder implements Builder<User> {
        private User user;

        private UserBuilder() {
            user = new User();
        }

        public UserBuilder withId(Long id) {
            user.id = id;
            return this;
        }

        public UserBuilder withFirstName(String firstName) {
            user.firstName = firstName;
            return this;
        }

        public UserBuilder withLastName(String lastName) {
            user.lastName = lastName;
            return this;
        }

        public UserBuilder withIdentifier(String identifier) {
            user.identifier = identifier;
            return this;
        }

        public UserBuilder withPhoneNumber(String phoneNumber) {
            user.phoneNumber = phoneNumber;
            return this;
        }

        public UserBuilder withCardNumber(String cardNumber) {
            user.cardNumber = cardNumber;
            return this;
        }

        public UserBuilder withBirthDate(Date birthDate) {
            user.birthDate = birthDate;
            return this;
        }

        public UserBuilder withRating(Integer rating) {
            user.rating = rating;
            return this;
        }

        public static UserBuilder user() {
            return new UserBuilder();
        }

        public User build() {
            return user;
        }
    }
}
