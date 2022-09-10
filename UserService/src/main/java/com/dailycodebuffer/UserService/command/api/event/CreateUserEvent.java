package com.dailycodebuffer.UserService.command.api.event;

import com.dailycodebuffer.CommonService.model.CardDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserEvent {
    private String userId;
    private String firstName;
    private String lastName;
    private CardDetails cardDetails;
}
