package com.example.personel.Service;

import com.example.personel.Entity.Personel;
import com.example.personel.Repository.PersonelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonelService {
    @Autowired
    private PersonelRepository personelRepository;



    public List<Personel> getAll(){
        return  personelRepository.findAll();
    }
    public Optional<Personel> getPersonel(int id){
        return  personelRepository.findById(id);
    }
    public Personel addPersonel(Personel personel) {
        return personelRepository.save(personel);
    }
    public Personel updatePersonel(int id, Personel newPersonel) {
        if (personelRepository.findById(id).isPresent()) {
            Personel existingPersonel = personelRepository.findById(id).get();
            existingPersonel.setCin(newPersonel.getCin());
            existingPersonel.setNom(newPersonel.getNom());
            existingPersonel.setPrenom(newPersonel.getPrenom());
            existingPersonel.setEmail(newPersonel.getEmail());
            existingPersonel.setMdp(newPersonel.getMdp());
            existingPersonel.setRole(newPersonel.getRole());
            existingPersonel.setTelephone(newPersonel.getTelephone());
            return personelRepository.save(existingPersonel);
        } else
            return null;
    }
    public String deletePersonel(int id) {
        if (personelRepository.findById(id).isPresent()) {
            personelRepository.deleteById(id);
            return "candidat supprimé";
        } else
            return "candidat non supprimé";
    }
}
