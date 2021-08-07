package com.zingmp3.controller;

import com.zingmp3.model.JwtResponse;
import com.zingmp3.model.User;
import com.zingmp3.model.UserPrinciple;
import com.zingmp3.service.JwtService;
import com.zingmp3.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUserService userService;

    @GetMapping("/home")
    public ModelAndView showLoginForm() {
        return new ModelAndView("/home");
    }

    @GetMapping("/layout")
    public ModelAndView showlayout() {
        return new ModelAndView("/layout");
    }


    @GetMapping("/api/list")
    public ResponseEntity<Iterable<User>> findAllApi() {
        Iterable<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<User> findByIdApi(@PathVariable Long id) {
        Optional<User> userOptional=userService.findById(id);
        if(!userOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/api/{username}")
    public ResponseEntity<User> findByUsernameApi(@PathVariable String username){
        Optional<User> userOptional=userService.findByUsername(username);
        if(!userOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/api/register")
    public ResponseEntity<?> registerApi(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> loginApi(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        User currentUser = userService.findByUsername(user.getUsername()).get();
        return ResponseEntity.ok(new JwtResponse(currentUser.getId(), jwt, userPrinciple.getUsername(), currentUser.getName(), userPrinciple.getAuthorities()));
    }

    @GetMapping("/api/hello")
    public ResponseEntity<String> helloApi() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}
