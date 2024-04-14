package com.api.medfacil.web.controller;


import com.api.medfacil.config.JWT.TokenDTO;
import com.api.medfacil.config.JWT.TokenService;
import com.api.medfacil.entities.User;
import com.api.medfacil.services.AuthService;
import com.api.medfacil.services.UserService;
import com.api.medfacil.web.dto.CodeDTO;
import com.api.medfacil.web.dto.CpfDTO;
import com.api.medfacil.web.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final AuthService authService;
    private final TokenService tokenService;

    @PostMapping("/generate-code")
    public ResponseEntity<CodeDTO> preLogin(@RequestBody CpfDTO cpfDTO){
        String code = authService.generateRandomCode();
        User user = userService.updatePassword(cpfDTO.cpf(), code);
        return ResponseEntity.ok(new CodeDTO(code));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO){
        try{
            var authToken = new UsernamePasswordAuthenticationToken(loginDTO.cpf(), loginDTO.password());
            Authentication auth = authenticationManager.authenticate(authToken);
            SecurityContextHolder.getContext().setAuthentication(auth);
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            TokenDTO token = new TokenDTO(tokenService.generateToken(user));
            return ResponseEntity.ok(token);
        }catch(AuthenticationException e){
            log.warn("Erro de autenticação: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
