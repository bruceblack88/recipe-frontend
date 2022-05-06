package com.galvanize.crudapicheckpoint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
//    @Query("SELECT * FROM users WHERE email")
//    Long authenticateUserId;
}
