package com.paxian.bootsecurity.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.paxian.bootsecurity.model.User;

import java.util.Arrays;
import java.util.List;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

@Service
public class DbInit implements CommandLineRunner {
    public UserRepository userRepository;
    public PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();

        // Crete users
        User pax = new User("pax",passwordEncoder.encode("pax123"),"USER","");
        User admin = new User("admin",passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager",passwordEncoder.encode("manager123"),"MANAGER","ACCESS_TEST1");

        List<User> users = Arrays.asList(pax,admin,manager);

        // Save to db
        this.userRepository.saveAll(users);
    }
}
