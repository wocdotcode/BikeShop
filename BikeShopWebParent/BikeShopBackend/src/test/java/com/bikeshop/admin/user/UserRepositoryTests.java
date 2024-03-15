package com.bikeshop.admin.user;


import com.bikeshop.common.entity.Role;
import com.bikeshop.common.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository repo;


    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void testCreateUserWithOneRole(){
        Role roleAdmin = entityManager.find(Role.class,1);
        User userWendell = new User("dellortiz06@gmail.com","1234", "Wendell", "Centeno");
        userWendell.addRole(roleAdmin);

        User savedUser = repo.save(userWendell);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void TestCreateUserWithTwoRole(){
        User userJane = new User("janedoe@gmail.com","1234", "Jane", "Doe");
        Role roleEditor = new Role(3);
        Role roleAssistant = new Role(5);

        userJane.addRole(roleEditor);
        userJane.addRole(roleAssistant);

        User savedUser = repo.save(userJane);

        assertThat(savedUser.getId()).isGreaterThan(0);


    }

    @Test
    public void testListAllUsers(){
        Iterable<User> listUsers = repo.findAll();
        listUsers.forEach(user -> System.out.println(user));

    }

    @Test
    public void TestGetUserById(){
       User userJane = repo.findById(2).get();
        System.out.println(userJane);
       assertThat(userJane).isNotNull();
    }

    @Test
    public void testUpdateUserDetails(){
        User userWendell = repo.findById(1).get();
        userWendell.setEnabled(true);
        userWendell.setPassword("123pass");

        repo.save(userWendell);

    }

    @Test
    public void testUpdateUserRoles(){
        User userJane = repo.findById(2).get();
        Role roleEditor = new Role(3);
        Role roleSalesPerson = new Role(2);
        userJane.getRoles().remove(roleEditor);

        userJane.addRole(roleSalesPerson);
        repo.save(userJane);
    }

    @Test
    public void testGetUserByEmail() {
        String email = "abcdef.com";
        User user = repo.getUserByEmail(email);

        assertThat(user).isNotNull();
    }

}
