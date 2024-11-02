package org.example.userauth.repositories;

import org.example.userauth.models.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends CrudRepository<Token, Integer> {

    Token save(Token token);
}