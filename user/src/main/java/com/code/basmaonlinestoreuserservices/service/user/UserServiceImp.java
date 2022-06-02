package com.code.basmaonlinestoreuserservices.service.user;

import com.code.basmaonlinestoreuserservices.entity.Role;
import com.code.basmaonlinestoreuserservices.entity.User;
import com.code.basmaonlinestoreuserservices.repository.RoleRepository;
import com.code.basmaonlinestoreuserservices.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class UserServiceImp implements UserService{


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    //private final PasswordEncoder passwordEncoder;
/*
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            System.out.println("if");
            log.error("User not found in the database{}", email);
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            //System.out.println("else "+ user.getEmail()+" "+user);
            log.info("User found in the database {} ", user.getEmail());

        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
      //  user.getIdRole().getNomRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(user.getRoles().toString()));
       // });
        log.info("after elsee : "+ user.getFirstName());
        log.info(authorities.toString());
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                authorities);
    }*/



/*    public void deleteUser(Long id){
        Long countById = userRepository.countById(id);
        if (countById == null || countById == 0){
            throw new UsernameNotFoundException("could not found a user with id : "+ id);
        }
        userRepository.deleteById(id);

    }*/


    public void encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }

    /*public Role role(Integer id){
        return roleRepository.findById(id).get();
    }


    public void addRoleToUser(String email, String roleName) {
        log.info("saving role to username");
        User user = userRepository.findUserByEmail(email);
        Role role = roleRepository.findRoleByNomRole(roleName);
        user.getIdRole().getNomRole();

    }*/

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }


    @Override
    public User saveUser(User user) {
        boolean isUpdatingUser = (user.getId() != null);

        if (isUpdatingUser) {
            User exisctingUser = userRepository.findById(user.getId()).get();
            if (user.getPassword().isEmpty()) {
                user.setPassword(exisctingUser.getPassword());
            } else {
                encodePassword(user);
            }
        } else {
            encodePassword(user);
        }

        return userRepository.save(user);
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }


}
