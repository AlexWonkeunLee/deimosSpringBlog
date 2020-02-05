package com.codeup.deimosspringblog.dao;

import com.codeup.deimosspringblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query
    User getUserById(long id);
}
