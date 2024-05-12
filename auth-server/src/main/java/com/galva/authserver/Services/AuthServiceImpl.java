package com.galva.authserver.Services;

import com.galva.authserver.dtos.TokenDto;
import com.galva.authserver.dtos.UserDto;
import com.galva.authserver.entities.UserEntity;
import com.galva.authserver.helpers.jwtHelper;
import com.galva.authserver.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Transactional
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final jwtHelper JwHelper;

    private static final String USER_EXCEPCION_MSG = "ERROR CON LA AUTORIZACIÒN";
    @Override
    public TokenDto login(UserDto user) {
        final var userFromDB = this.userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED,USER_EXCEPCION_MSG));

        this.validPaassword(user,userFromDB);

        return TokenDto.builder().accessToken(this.JwHelper.creatToken(userFromDB.getUsername())).build();
    }

    @Override
    public TokenDto validateToken(TokenDto token) {
        if(this.JwHelper.validateToken(token.getAccessToken())){
               return TokenDto.builder().accessToken(token.getAccessToken()).build();
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, USER_EXCEPCION_MSG);
    }

    private void validPaassword(UserDto userDto, UserEntity userEntity)
    {
        if(this.passwordEncoder.matches(userDto.getPassword(),userEntity.getPassword()))
        {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,USER_EXCEPCION_MSG);
        }
    }
}
