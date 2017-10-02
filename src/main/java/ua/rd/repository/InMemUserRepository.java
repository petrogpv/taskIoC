package ua.rd.repository;

import ua.rd.domain.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class InMemUserRepository implements UserRepository {
    private static Long idCounter = Long.valueOf(0);
    private Map<Long,User> userRepo = new HashMap<>();

    public InMemUserRepository(){}
    
    @Override
    public User save(User user) {
        if(user.getId()==null) {
            user.setId(idCounter++);
        }
        put(user);
        return user;
    }

    @Override
    public Iterable<User> allUsers() {
        return userRepo.values();
    }

    @Override
    public Optional<User> getUser(Long userId) {
        return Optional.ofNullable(userRepo.get(userId));
    }

    @Override
    public Optional<User> getUserByName(String username) {
        return userRepo.values().stream().filter(user->user.getName().equals(username)).findFirst();
    }


    private User put(User user) {
        return userRepo.put(user.getId(),user);
    }
}
