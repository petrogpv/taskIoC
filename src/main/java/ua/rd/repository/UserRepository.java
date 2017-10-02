package ua.rd.repository;

import ua.rd.domain.Tweet;
import ua.rd.domain.User;

import java.util.Optional;

/**
 * Created by Petro_Gordeichuk on 10/2/2017.
 */
public interface UserRepository {
    Iterable<User> allUsers();

    Optional<User> getUser(Long id);

    Optional<User> getUserByName(String name);

    User save(User user);
}
