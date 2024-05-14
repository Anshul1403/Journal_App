package com.Anshul.myjournal.Service;

import com.Anshul.myjournal.Entities.JournalEntry;
import com.Anshul.myjournal.Entities.User;
import com.Anshul.myjournal.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
public class UserService  {


    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private static final PasswordEncoder passwordencoder  = new BCryptPasswordEncoder();

    public void saveUser(User user){

        User User = userRepository.save(user);
    }

    public boolean createNewUser(User user){
        try{
            user.setPassword(passwordencoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            User User = userRepository.save(user);
            return true;
        }
        catch(Exception e){
            logger.info("error in userservicee | create new user",e);
            return false;
        }
    }

    public void saveadmin(User user){
        user.setPassword(passwordencoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        User User = userRepository.save(user);
    }

    public List<User> GetUser(){
        List<User> AllUser =userRepository.findAll();
        return AllUser;
    }

    public Optional<User> getUserById(ObjectId id){

        return userRepository.findById(id);
    }



    public void deleteByID(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUserName(String Username){
        return userRepository.findByUserName(Username);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

}
