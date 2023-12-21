package tn.esprit.authentification1.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.authentification1.Controller.AuthentificationResponse;
import tn.esprit.authentification1.Entity.Personel;
import tn.esprit.authentification1.Entity.Role;
import tn.esprit.authentification1.Entity.User;
import tn.esprit.authentification1.Repos.IPersonelrepo;
import tn.esprit.authentification1.Repos.IUserRepo;
import tn.esprit.authentification1.Security.JwtService;

@Service
@RequiredArgsConstructor
public class
AuthentificationServiceImplements implements AuthentificationService{

    private final IUserRepo iUserRepo ;
    private final IPersonelrepo iPersonelrepo ;
    private final PasswordEncoder passwordEncoder ;
    private final JwtService jwtService ;
    private final AuthenticationManager authenticationManager ;
    @Override
    public Personel registerPersonel(Personel personel) {
        personel.setPassword(passwordEncoder.encode(personel.getPassword()));
        personel.setRole(Role.PERSONEL);
        return iPersonelrepo.save(personel);
    }
    public boolean emailExists(String email) {
        // Logique pour vérifier si l'e-mail existe déjà dans la base de données
        return iUserRepo.existsByEmail(email);
    }

    @Override
    public AuthentificationResponse login(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        var user = iUserRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("utilisateur non trouvé"));
        var jwt = jwtService.generateToken(user);

        AuthentificationResponse authenticationResponse = new AuthentificationResponse();
        authenticationResponse.setToken(jwt);

        if (user.getRole() == Role.PERSONEL) {
            Personel personel = (Personel) user;
            Personel personelDto = convertToPersonelDto(personel);
            authenticationResponse.setUser(personelDto);
        } else {
            User userDetails = convertToUserDto(user);
            authenticationResponse.setUser(userDetails);
        }

        return authenticationResponse;
    }

    private User convertToUserDto(User user) {
        User dto = new User();
        dto.setId(user.getId());
        dto.setNom(user.getNom());
        dto.setPrenom(user.getPrenom());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        return dto;
    }

    private Personel convertToPersonelDto(Personel personel) {
        Personel dto = new Personel();
        dto.setId(personel.getId());
        dto.setNom(personel.getNom());
        dto.setPrenom(personel.getPrenom());
        dto.setEmail(personel.getEmail());
        dto.setPassword(personel.getPassword());
        dto.setRole(personel.getRole());
        dto.setCin(personel.getCin());
//        dto.setDateNaissance(personel.getDateNaissance());
        return dto;
    }


}
