package com.example.mybook.controller;

import com.example.mybook.model.UserInfo;
import com.example.mybook.service.serviceImplementation.PostServiceImpl;
import com.example.mybook.service.serviceImplementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class UserController {

    final private UserServiceImpl userServiceImpl;
    final private PostServiceImpl postServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl, PostServiceImpl postServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.postServiceImpl = postServiceImpl;
    }




    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("loginRequest", new UserInfo());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login_page";
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute UserInfo userInfo){

        System.out.println(userInfo);
        UserInfo user = new UserInfo();
        user.setFirstname(userInfo.getFirstname());
        user.setLastname(userInfo.getLastname());
        user.setUsername(userInfo.getUsername());
        user.setEmail(userInfo.getEmail());
        user.setDate_of_birth(userInfo.getDate_of_birth());
        user.setGender(userInfo.getGender());
        user.setNumber(userInfo.getNumber());


        UserInfo userInfo1 = userServiceImpl.saverUser(userInfo);
        System.out.println(userInfo1);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login_page");
        modelAndView.addObject("userInfo", userInfo);
        return modelAndView;

    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserInfo userInfo, Model model, HttpSession httpSession, Model model2) {

        System.out.println("Login request: " + userInfo);
        UserInfo authenticated = userServiceImpl.authenticate(userInfo.getEmail(), userInfo.getPassword());
        if (authenticated != null) {
            System.out.println("LoggedIn User: " + authenticated);
            httpSession.setAttribute("user", authenticated);
            model.addAttribute("userLogin", authenticated.getFirstname() + " " + authenticated.getLastname());

            postServiceImpl.viewDashboard(model2);
            return "dashboard";

        } else {
            String message = "Incorrect login details. Wrong email or password. ";
            model.addAttribute("errorMessage", message);
            model.addAttribute("errorNotice", "RETURN TO LOGIN PAGE");
            model.addAttribute("errorLink", "/login");
            return "error";
        }
    }

    @GetMapping("/dashboard")
    public String getDashBoard(Model model, HttpSession session, Model model1) {
        boolean validSession = session.getAttribute("user") == null;
        postServiceImpl.viewDashboard(model);
        model1.addAttribute("errorMessage", "Invalid session.");
        model1.addAttribute("errorNotice", "RETURN TO LOGIN PAGE");
        model1.addAttribute("errorLink", "/login");

        return validSession ? "error" : "dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login_page";
    }
    @GetMapping("/getpeoplelist")
    public String getAllUsers(Model model){
        model.addAttribute("list", new UserInfo());
        List<UserInfo> listOfUsers = userServiceImpl.findAllUser();
        return "listOfUsers";
    }

  /*  @PostMapping("/validate")
    public ResponseEntity<String> validateObject(@RequestBody @Valid Person person) {
        return new ResponseEntity("User validated successfully", HttpStatus.OK);
    }*/
//
//    @RequestMapping("/error")
//    public String getDefaultError(Model model) {
//        String message = "You have entered a wrong URL";
//        model.addAttribute("errorMessage", message);
//        model.addAttribute("errorNotice", "RETURN TO DASHBOARD PAGE");
//        model.addAttribute("errorLink", "/dashboard");
//        return "error";
//    }
}
