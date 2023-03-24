package com.dailycodebuffer.UserService.query.api.repository;

import com.dailycodebuffer.UserService.query.api.pojo.UserData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface IUserRepository extends MongoRepository<UserData, String> {

    @Query("{userId:'?0'}")
    UserData findByUserId(String name);

    public long count();
}
