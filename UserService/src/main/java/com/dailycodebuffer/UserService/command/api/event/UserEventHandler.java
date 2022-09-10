package com.dailycodebuffer.UserService.command.api.event;

import com.dailycodebuffer.CommonService.model.User;
import com.dailycodebuffer.UserService.query.api.pojo.UserData;
import com.dailycodebuffer.UserService.query.api.repository.IUserRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("user")
public class UserEventHandler {

    IUserRepository userRepository;

    public UserEventHandler(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventHandler
    public void on(CreateUserEvent event) {
        UserData userData = UserData.builder()
                .userId(event.getUserId())
                .firstName(event.getFirstName())
                .lastName(event.getLastName())
                .build();
        //BeanUtils.copyProperties(event, user);
        System.out.println("write to db");
        userRepository.insert(userData);

    }

    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        throw exception;
    }
}

