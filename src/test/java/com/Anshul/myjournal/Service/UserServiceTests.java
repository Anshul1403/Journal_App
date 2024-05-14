package com.Anshul.myjournal.Service;

import com.Anshul.myjournal.Entities.User;
import com.Anshul.myjournal.Repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Disabled
    @Test
    public void testFindByUserName(){
        assertNotNull(userRepository.findByUserName("ram"));

    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void TestCreateUser(User user){
        assertTrue(userService.createNewUser(user));

    }


    @ParameterizedTest
    @CsvSource({
            "ram","Anshul"
    })
    public void testFindByUserName(String name){
        assertNotNull(userRepository.findByUserName(name),"failed for" + name);

    }





    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "2,3,5",

    })
    public void test(int a,int b, int expected){
        assertEquals(expected, a+b);
    }
}
