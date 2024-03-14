package com.bikeshop.admin.user;


import com.bikeshop.common.entity.Role;
import com.bikeshop.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> listAll() {
        return (List<User>) userRepo.findAll();
    }
    
    public List<Role> listRoles() {
        return (List<Role>) roleRepo.findAll();
    }


    private void encodePassword(User user){
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
    }

    public void save(User user){
        encodePassword(user);
        userRepo.save(user);
    }
}
