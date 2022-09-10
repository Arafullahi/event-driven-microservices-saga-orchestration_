package com.dailycodebuffer.UserService.query.api.projection;

import com.dailycodebuffer.CommonService.model.CardDetails;
import com.dailycodebuffer.CommonService.model.User;
import com.dailycodebuffer.UserService.query.api.query.UserDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsProjection {

    @QueryHandler
    public User handle(UserDetailsQuery query) {
        //Ideally Get the details from the DB
        System.out.println("test line for query");
        CardDetails cardDetails
                = CardDetails.builder()
                .name("Shabbir Dawoodi")
                .validUntilYear(2022)
                .validUntilMonth(01)
                .cardNumber("123456789")
                .cvv(111)
                .build();

        return User.builder()
                .userId("hdhdh")
                .firstName("Shabbir")
                .lastName("Dawoodi")
                .cardDetails(cardDetails)
                .build();
    }
}
