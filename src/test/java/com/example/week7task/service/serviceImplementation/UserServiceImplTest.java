package com.example.week7task.service.serviceImplementation;

import com.example.week7task.model.UserInfo;
import com.example.week7task.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private UserInfo userInfo;


    @BeforeEach
    void setUp() {
        userInfo = new UserInfo();
        userInfo.setFirstname("Oga");
        userInfo.setLastname("Bright");
        userInfo.setUsername("OgaBright4lyf");
        userInfo.setPassword("24680");
        userInfo.setEmail("ogabright@gmail.com");
        userInfo.setDate_of_birth("10/10/1985");
        userInfo.setGender("Male");
        userInfo.setNumber("08188693160");
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void findAllUser() {

        //mock userRepository
       when(userRepository.findAll()).thenReturn(List.of(userInfo));  // pass in the mock list to the parenthesis and test assertions

        //call the method to be tested

        List<UserInfo> allUser = userService.findAllUser();

        //assertions
        Assertions.assertEquals("[UserInfo(id=null, firstname=Oga, lastname=Bright, " +
                "email=ogabright@gmail.com, password=24680, username=OgaBright4lyf, " +
                "date_of_birth=10/10/1985, gender=Male, number=08188693160)]", Arrays.toString(allUser.toArray()));

    }

    @Test
    void saverUser() {


       /* public UserInfo saverUser(UserInfo userInfo) {
            if (userRepository.findByEmail(userInfo.getEmail()).isPresent()) {
                System.out.println("This mail is in use");
                return null;
            }
            return userRepository.save(userInfo);*/

        //mock userRepository
        when(userRepository.save(any(UserInfo.class))).thenReturn(userInfo);

        // call the method to be tested

        userService.saverUser(userInfo);

        // Assertions

        verify(userRepository, times(1)).save(any(UserInfo.class));
    }

    @Test
    void authenticate() {
        // UserInfo authenticate(String email, String password);
       // public UserInfo authenticate(String email, String password){
         //   return userRepository.findByEmailAndPassword(email, password).orElse(null);

        when(userRepository.findByEmailAndPassword(anyString(), anyString())).thenReturn(Optional.of(userInfo));

        UserInfo userInf = userService.authenticate(userInfo.getEmail(), userInfo.getPassword());
        System.out.println(userInf);

        Assertions.assertEquals("ogabright@gmail.com", userInf.getEmail());
        Assertions.assertEquals("24680", userInf.getPassword());


    }
}