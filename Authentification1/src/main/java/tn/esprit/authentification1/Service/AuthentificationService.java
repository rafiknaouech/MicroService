package tn.esprit.authentification1.Service;


import tn.esprit.authentification1.Controller.AuthentificationResponse;
import tn.esprit.authentification1.Entity.Personel;

public interface AuthentificationService {
    public Personel registerPersonel(Personel personel);

    AuthentificationResponse login(String email, String password);

}
