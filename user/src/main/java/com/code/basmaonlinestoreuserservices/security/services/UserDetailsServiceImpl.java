package com.code.basmaonlinestoreuserservices.security.services;

import com.code.basmaonlinestoreuserservices.entity.User;
import com.code.basmaonlinestoreuserservices.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
@Slf4j

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            System.out.println("if");
            log.error("User not found in the database{}"+ email);
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            //System.out.println("else "+ user.getEmail()+" "+user);
            log.info("User found in the database {} ", user.getRoles());

        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //  user.getIdRole().getNomRole().forEach(role -> {
        authorities.add(new SimpleGrantedAuthority(user.getRoles().toString()));
        // });
        log.info("after elsee : "+ user.getFirstName());
        log.info(authorities.toString());
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                authorities);
    }


}
