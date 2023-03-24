package com.dailycodebuffer.UserService.query.api.projection;

import com.dailycodebuffer.CommonService.model.User;
import com.dailycodebuffer.UserService.query.api.pojo.UserData;
import com.dailycodebuffer.UserService.query.api.query.UserDetailsQuery;
import com.dailycodebuffer.UserService.query.api.repository.IUserRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsProjection {

    IUserRepository userRepository;

    public UserDetailsProjection(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryHandler
    public User handle(UserDetailsQuery query) {
        //Ideally Get the details from the DB
        System.out.println("repository Call");
        UserData userData =  userRepository.findByUserId(query.getUserId());
       return User.builder().userId(userData.getUserId())
                .firstName(userData.getFirstName())
                .firstName(userData.getLastName()).build();
    }
}
