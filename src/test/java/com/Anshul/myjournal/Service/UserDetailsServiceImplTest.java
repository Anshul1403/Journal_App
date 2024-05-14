package com.Anshul.myjournal.Service;

import com.Anshul.myjournal.Entities.User;
import com.Anshul.myjournal.Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.mockito.Mockito.when;


public class UserDetailsServiceImplTest {

    @InjectMocks
    private UserDetailsServiceIMPL userDetailsServiceIMPL;

    @Mock
    private UserRepository userRepository;

@BeforeEach
void Setup(){
    MockitoAnnotations.initMocks(this);
}

    @Test
    void loadUserByUsername(){
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("ram").password("cvhcgac").roles(new ArrayList<>()).build());
        UserDetails user = userDetailsServiceIMPL.loadUserByUsername("ram");
        Assertions.assertNotNull(user);
    }
}
