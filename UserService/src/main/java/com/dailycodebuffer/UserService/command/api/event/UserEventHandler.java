package com.dailycodebuffer.UserService.command.api.event;

import com.dailycodebuffer.CommonService.model.User;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("user")
public class UserEventHandler {

    @EventHandler
    public void on(CreateUserEvent event) {
        User user = User.builder()
                .cardDetails(event.getCardDetails())
                .userId(event.getUserId())
                .firstName(event.getFirstName())
                .lastName(event.getLastName())
                .build();
        BeanUtils.copyProperties(event, user);
        System.out.println("write to db");
    }

    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        throw exception;
    }
}

