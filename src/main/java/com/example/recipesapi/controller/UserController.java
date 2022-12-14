package com.example.recipesapi.controller;

import com.example.recipesapi.dto.LoginDTO;
import com.example.recipesapi.dto.RegistrationDTO;
import com.example.recipesapi.dto.TokenDTO;
import com.example.recipesapi.entity.User;
import com.example.recipesapi.security.JwtTokenUtil;
import com.example.recipesapi.security.JwtUserDetailsService;
import com.example.recipesapi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;
    @Autowired
    UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    ModelMapper modelMapper;



    @PostMapping("register")
    public ResponseEntity<RegistrationDTO> register(@RequestBody RegistrationDTO registrationDTO){


        return new ResponseEntity<>(modelMapper.map(userService.add(modelMapper.map(registrationDTO, User.class)),RegistrationDTO.class), HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO) throws Exception{
        Optional<User> optionalUser = userService.findByEmail(loginDTO.getEmail());

        if(optionalUser.isEmpty()){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(optionalUser.get().getId(), loginDTO.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }


        final UserDetails userDetails = jwtUserDetailsService
                .loadUserByUsername(String.valueOf(optionalUser.get().getId()));

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new TokenDTO(token));
    }


    @PutMapping("edit")
    public ResponseEntity<RegistrationDTO>edit (@RequestBody RegistrationDTO registrationDTO){

        return null;
    }



}
