package com.grakovich.salesaccountingserver.service;

import com.grakovich.salesaccountingserver.model.Product;
import com.grakovich.salesaccountingserver.model.Role;
import com.grakovich.salesaccountingserver.model.User;
import com.grakovich.salesaccountingserver.model.UserStatus;
import com.grakovich.salesaccountingserver.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private User currentUser;
    @Autowired
    private UserRepo userRepo;

    public UserStatus loginUser(User user) {
        Optional<User> u = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (u.isPresent()){
            currentUser = u.get();
            if (currentUser.getRole().equals(Role.ADMIN))
                return UserStatus.CREATED_ADMIN;
            if (currentUser.getRole().equals(Role.USER))
                return UserStatus.CREATED_USER;
        }
        return UserStatus.UNKNOWER;
    }

    public boolean registerUser(User user) {
        Optional<User> u = userRepo.findByUsername(user.getUsername());
        if (u.isPresent() == false){
            userRepo.save(user);
            return true;
        }
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public boolean update(User user) {
        boolean b = userRepo.existsByUsername(user.getUsername());
        Optional<User> byId = userRepo.findById(user.getId());
        if (user.getUsername().equals(byId.get().getUsername()) || !userRepo.existsByUsername(user.getUsername())){
            userRepo.save(user);
            return true;
        }
        return false;
    }

    public boolean add(User user) {
        userRepo.save(user);
        return true;
    }

    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}
