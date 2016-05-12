package org.learning.caristuff.domain.repository;

import org.learning.caristuff.domain.entities.User;
import org.learning.caristuff.domain.jpa.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kinks on 5/12/2016.
 */
@Repository
public class UserRepository extends JpaRepository<User, Long> {

    public UserRepository() {
        super(User.class);
    }
}
