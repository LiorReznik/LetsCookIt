package com.example.letscookit.users.business;

import com.example.letscookit.users.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(User user) {
        String email = user.getEmail();
        System.out.println(email);
        if (this.userRepository.findByEmail(email).isEmpty()) {
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));
            System.out.println(user.getPassword());

            this.userRepository.save(user);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists");
        }
    }
}
