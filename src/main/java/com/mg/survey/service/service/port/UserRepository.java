package com.mg.survey.service.service.port;

import com.mg.survey.service.domain.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, String> {

    User findByUserName(String userName);

}
