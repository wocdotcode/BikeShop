package com.bikeshop.admin.user;

import com.bikeshop.common.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {


}
