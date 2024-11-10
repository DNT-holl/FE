package com.example.theater.services;

import com.example.theater.entities.AppUser;
import com.example.theater.repositories.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppUserService implements UserDetailsService {
    @Autowired
    private AppUserRepo appUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepo.findByUsername(username);

        if (appUser != null) {
            return User.withUsername(appUser.getUsername()).password(appUser.getPassword()).build();
        }
        else {
            throw new UsernameNotFoundException(username);
        }
    }

    //reset pass
//    public void updateResetPasswordToken(String token, String email) throws UsernameNotFoundException {
//        AppUser appUser = appUserRepo.findByEmail(email);
//        if (appUser != null) {
//            appUser.setResetPasswordToken(token);
//            appUserRepo.save(appUser);
//        }
//        else {
//            throw new UsernameNotFoundException("Could not find any customer with the email " + email);
//        }
//    }

//    public AppUser getByResetPasswordToken(String token) {
//        return appUserRepo.findByResetPasswordToken(token);
//    }
//    public void updatePassword(AppUser appUser, String newPassword) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(newPassword);
//        appUser.setPassword(encodedPassword);
//        appUser.setResetPasswordToken(null);
//        appUserRepo.save(appUser);
//    }



}
