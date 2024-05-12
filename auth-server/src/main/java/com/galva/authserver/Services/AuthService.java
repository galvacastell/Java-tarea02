package com.galva.authserver.Services;

import com.galva.authserver.dtos.TokenDto;
import com.galva.authserver.dtos.UserDto;

public interface AuthService {
    TokenDto login(UserDto user);
    TokenDto validateToken(TokenDto token);

}
