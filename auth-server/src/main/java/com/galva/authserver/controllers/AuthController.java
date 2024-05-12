package com.galva.authserver.controllers;

import com.galva.authserver.Services.AuthService;
import com.galva.authserver.dtos.TokenDto;
import com.galva.authserver.dtos.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(path = "login")
    public ResponseEntity<TokenDto> jwtCreate(@RequestBody UserDto user)
    {
        return ResponseEntity.ok(this.authService.login(user));
    }

    @PostMapping(path = "jwt")
    public ResponseEntity<TokenDto> jwtValidate(@RequestHeader String accesToken)
    {
        return ResponseEntity.ok(this.authService.validateToken(TokenDto.builder().accessToken(accesToken).build()));
    }
}





