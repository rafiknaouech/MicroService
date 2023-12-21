package tn.esprit.authentification1.Service;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;




public interface IUserService {
    UserDetailsService userDetailsService();
}
