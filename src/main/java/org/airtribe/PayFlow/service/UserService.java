package org.airtribe.PayFlow.service;

import org.airtribe.PayFlow.entity.User;
import org.airtribe.PayFlow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    // Spring automatically injects UserRepository at startup through dependency injection.
    // This works because Spring creates a bean for UserRepository (since it's a JpaRepository)
    // and injects it wherever @Autowired is used.
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByUpiId(String upiId) {
        return userRepository.findByUpiId(upiId);
    }
}