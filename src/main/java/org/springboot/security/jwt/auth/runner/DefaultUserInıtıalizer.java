package org.springboot.security.jwt.auth.runner;

import org.springboot.security.jwt.auth.dao.entity.User;
import org.springboot.security.jwt.auth.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserInıtıalizer implements ApplicationRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DefaultUserInıtıalizer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) {
        // Admin kullanıcısını oluşturup veritabanına kaydetme
        String adminUsername = "Admin";
        String adminPassword = "admin123"; // Şifrelenmemiş hali

        // Şifreyi şifrele
        String encodedPassword = passwordEncoder.encode(adminPassword);

        // Kullanıcıyı oluştur ve veritabanına kaydet
        User adminUser = new User();
        adminUser.setUsername(adminUsername);
        adminUser.setPassword(encodedPassword);
        userRepository.save(adminUser);
    }
}
