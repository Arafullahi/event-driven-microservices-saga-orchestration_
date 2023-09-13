package com.dailycodebuffer.UserService.controller;

import com.dailycodebuffer.CommonService.model.User;
import com.dailycodebuffer.UserService.command.api.commands.CreateUserCommand;
import com.dailycodebuffer.UserService.query.api.query.UserDetailsQuery;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private transient final QueryGateway queryGateway;

    private transient final CommandGateway commandGateway;

    public UserController(QueryGateway queryGateway, CommandGateway commandGateway) {
        this.queryGateway = queryGateway;
        this.commandGateway = commandGateway;
    }

    @GetMapping("{userId}")
    public User getUserPaymentDetails(@PathVariable String userId){
        UserDetailsQuery userDetailsQuery
                =  UserDetailsQuery.builder().userId(userId).build();
        User user =
                queryGateway.query(userDetailsQuery,
                        ResponseTypes.instanceOf(User.class)).join();

        return user;
    }

    @GetMapping
    public String getUserPaymentDetails(){

        return "welcome";
    }

    @PostMapping
    public String createUser(@RequestBody User user){
        CreateUserCommand createUserCommand = CreateUserCommand.builder()
                .cardDetails(user.getCardDetails())
                .userId(UUID.randomUUID().toString())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
        String result = commandGateway.sendAndWait(createUserCommand);

        return result;
    }
}
