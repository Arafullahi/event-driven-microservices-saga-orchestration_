package com.dailycodebuffer.UserService.query.api.pojo;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("User")
public class UserData {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
}
