package com.project.loremaster.controllers;

import com.project.loremaster.dto.AuthResponseDto;
import com.project.loremaster.dto.LoginDto;
import com.project.loremaster.dto.RegisterDto;
import com.project.loremaster.entity.UsersEntity;
import com.project.loremaster.repositories.UsersRepository;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import io.jsonwebtoken.Jwts;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/users")
public class UsersController {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private static final String KEY = "d04jr0NIz4j0zURu0Euy3QtqFFZcpnrLol6HpyYtV6SMcYGBOwL9A41b355meW7";

    public UsersController(UsersRepository usersRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/get")
    public ResponseEntity<AuthResponseDto> getUsers(@RequestBody LoginDto loginDto){
        Authentication authetication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getLogin(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authetication);
        UsersEntity user = usersRepository.findByEmail(loginDto.getLogin()).orElse(null);

        String token = Jwts
                .builder()
                .setClaims(new HashMap<>())
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(Keys.hmacShaKeyFor(Base64.getDecoder().decode(KEY)), SignatureAlgorithm.HS256)
                .compact();
        return ResponseEntity.ok(AuthResponseDto.builder().token(token).build());
        //return new ResponseEntity<>("login success", HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addUser(@RequestBody RegisterDto registerDto){
        UsersEntity user = new UsersEntity();
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getLogin());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        try {
            usersRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
