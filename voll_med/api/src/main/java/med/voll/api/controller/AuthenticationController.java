package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.user.Login;
import med.voll.api.domain.user.User;
import med.voll.api.infra.security.TokenJWT;
import med.voll.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid Login data) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());

            var authentication = authenticationManager.authenticate(authenticationToken);
            System.out.println(authentication);
            var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());

            return ResponseEntity.ok(new TokenJWT(tokenJWT));
        }catch (Exception e) {
            e.printStackTrace();
            return  ResponseEntity.badRequest().body(e.getMessage());

        }
    }
}
