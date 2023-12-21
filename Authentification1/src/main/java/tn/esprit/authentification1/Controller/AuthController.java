package tn.esprit.authentification1.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.authentification1.Entity.Personel;
import tn.esprit.authentification1.Entity.User;
import tn.esprit.authentification1.Repos.IPersonelrepo;
import tn.esprit.authentification1.Repos.IUserRepo;
import tn.esprit.authentification1.Service.AuthentificationService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@ControllerAdvice
@CrossOrigin("http://localhost:4200")
public class AuthController {
    private final AuthentificationService services;
    private final IPersonelrepo PersonelRepo;
    private final IUserRepo iUserRepositries ;

    @PostMapping("/registerPersonel")
    public ResponseEntity<Personel> registerPersonel(@RequestBody Personel personel) { // Cette annotation permet de lier automatiquement les paramètres de la requête aux propriétés d'un objet.
        // Appel à un service pour enregistrer l'étudiant
        Personel savedPersonel = services.registerPersonel(personel);

        // Renvoi de la réponse avec l'étudiant enregistré
        return ResponseEntity.ok(savedPersonel);
    }
    @GetMapping("/checkEmailExists")
    public ResponseEntity<Boolean> checkEmailExists(@RequestParam String email) {
        boolean exists = iUserRepositries.existsByEmail(email);
        return ResponseEntity.ok(exists);
    }

    @PostMapping("/login")
    public AuthentificationResponse login(@RequestBody User user) {
        return services.login(user.getEmail() , user.getPassword());
    }



}
