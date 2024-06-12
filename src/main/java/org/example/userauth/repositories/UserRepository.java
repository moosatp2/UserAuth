package org.example.userauth.repositories;

import org.example.userauth.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}