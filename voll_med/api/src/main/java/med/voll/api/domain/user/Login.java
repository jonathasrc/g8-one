package med.voll.api.domain.user;

import org.springframework.security.core.userdetails.UserDetails;

public record Login(String login, String password){}
