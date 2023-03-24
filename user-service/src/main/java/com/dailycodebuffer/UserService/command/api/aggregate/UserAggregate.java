package com.dailycodebuffer.UserService.command.api.aggregate;

import com.dailycodebuffer.CommonService.model.CardDetails;
import com.dailycodebuffer.UserService.command.api.commands.CreateUserCommand;
import com.dailycodebuffer.UserService.command.api.event.CreateUserEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class UserAggregate {
    @AggregateIdentifier
    private String userId;
    private String firstName;
    private String lastName;
    private CardDetails cardDetails;

    @CommandHandler
    public UserAggregate(CreateUserCommand createUserCommand){
        CreateUserEvent createUserEvent = new CreateUserEvent();
        BeanUtils.copyProperties(createUserCommand, createUserEvent);
        AggregateLifecycle.apply(createUserEvent);
    }

    public UserAggregate() {

    }
    @EventSourcingHandler
    public void on(CreateUserEvent createUserEvent) {
        this.userId = createUserEvent.getUserId();
        this.firstName = createUserEvent.getFirstName();
        this.lastName = createUserEvent.getLastName();
        this.cardDetails = createUserEvent.getCardDetails();
    }
}
