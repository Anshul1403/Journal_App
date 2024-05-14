package com.Anshul.myjournal.Repository;

import com.Anshul.myjournal.Entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(String username);
    void  deleteByUserName(String username);
}
