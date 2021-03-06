package com.paxian.bootsecurity.db;

import com.paxian.bootsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbInit implements CommandLineRunner {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    /*public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }*/

    @Override
    public void run(String... args) {

        // Crete users
        User pax = new User("pax",passwordEncoder.encode("pax123"),"USER","");
        User matt = new User("matt",passwordEncoder.encode("matt123"),"MANAGER","ACCESS_TEST1,ACCESS_TEST2");
        User wendy = new User("wendy",passwordEncoder.encode("wendy123"),"ADMIN","ACCESS_TEST1");
        User admin = new User("admin",passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager",passwordEncoder.encode("manager123"),"MANAGER","ACCESS_TEST1");

        // Delete all
        this.userRepository.deleteAll();

        // Save to db
        List<User> users = Arrays.asList(pax,matt,wendy,admin,manager);
        this.userRepository.saveAll(users);
    }
}
