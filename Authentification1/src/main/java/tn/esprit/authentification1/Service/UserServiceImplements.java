package tn.esprit.authentification1.Service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.authentification1.Repos.IUserRepo;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImplements implements IUserService{

    private final IUserRepo iUserRepo ;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return iUserRepo.findByEmail(username).orElseThrow(()->new RuntimeException("utilisateur non trouvé"));
            }
        };
    }
}

