package com.dailycodebuffer.UserService.projection;

import com.dailycodebuffer.CommonService.model.CardDetails;
import com.dailycodebuffer.CommonService.model.User;
import com.dailycodebuffer.CommonService.queries.GetUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserProjection {

    @QueryHandler
    public User handle(GetUserPaymentDetailsQuery query) {
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
