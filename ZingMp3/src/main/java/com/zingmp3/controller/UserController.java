package com.zingmp3.controller;

import com.zingmp3.model.JwtResponse;
import com.zingmp3.model.Role;
import com.zingmp3.model.User;
import com.zingmp3.model.UserPrinciple;
import com.zingmp3.service.JwtService;
import com.zingmp3.service.role.IRoleService;
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

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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

    @Autowired
    private IRoleService roleService;

    @GetMapping("/api/list")
    public ResponseEntity<Iterable<User>> findAll() {
        Iterable<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> userOptional=userService.findById(id);
        if(!userOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/api/search")
    public ResponseEntity<User> findByUsername(@RequestParam String username){
        Optional<User> userOptional=userService.findByUsername(username);
        if(!userOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/api/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        Optional<Role> roleOptional=roleService.findById(2L);
        Set<Role> roles=new HashSet<Role>();
        roles.add(roleOptional.get());
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        User currentUser = userService.findByUsername(user.getUsername()).get();
        return ResponseEntity.ok(new JwtResponse(currentUser.getId(), jwt, userPrinciple.getUsername(), currentUser.getName(), userPrinciple.getAuthorities()));
    }

    @PutMapping("/api/{id}")
    public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User user){
        Optional<User> userOptional=userService.findById(id);
        if(!userOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        user.setId(userOptional.get().getId());
        userService.save(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
