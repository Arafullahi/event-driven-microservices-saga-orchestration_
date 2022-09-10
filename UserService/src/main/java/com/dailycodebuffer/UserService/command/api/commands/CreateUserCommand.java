package com.dailycodebuffer.UserService.command.api.commands;

import com.dailycodebuffer.CommonService.model.CardDetails;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateUserCommand {

    @TargetAggregateIdentifier
    private String userId;
    private String firstName;
    private String lastName;
    private CardDetails cardDetails;
}
