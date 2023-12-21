package tn.esprit.authentification1.Repos;

import tn.esprit.authentification1.Entity.Personel;
import org.springframework.data.repository.CrudRepository;

public interface IPersonelrepo extends CrudRepository<Personel, Long> {
        Personel findByCin (long cin);
    }

