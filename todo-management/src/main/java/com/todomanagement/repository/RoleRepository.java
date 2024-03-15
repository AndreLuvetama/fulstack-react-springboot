package com.todomanagement.repository;

import com.todomanagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface RoleRepository extends JpaRepository<Role, Long> {
//    public static void main(String[] args) {
//        PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
//        System.out.println(passwordEncoder.encode("sa123"));
//        System.out.println(passwordEncoder.encode("admin"));
//
//    }
    Role findByName(String name);
}
