package org.example.userauth.repositories;

import org.example.userauth.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
//    User save(User user);
    User findUserByEmail(String email);
    User findUserById(Long id);
}