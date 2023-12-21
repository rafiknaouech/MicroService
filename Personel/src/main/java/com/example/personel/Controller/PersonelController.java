package com.example.personel.Controller;

import com.example.personel.Entity.Personel;
import com.example.personel.Repository.PersonelRepository;
import com.example.personel.Service.PersonelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Personel")
public class PersonelController {
    @Autowired
    private PersonelService personelService;

   @GetMapping(value = "/ListPersonel",produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseStatus(HttpStatus.OK)
   public List<Personel> getAll(){
       return personelService.getAll() ;
   }
    @GetMapping(value = "/ListPersonel/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Personel getPersonel(@PathVariable(value = "id") int id){
       return personelService.getPersonel(id).get();

    }



    @PostMapping(value = "/addPersonel",consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Personel> createPersonel(@RequestBody Personel personel) {
        return new ResponseEntity<>(personelService.addPersonel(personel), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Personel> updateCandidat(@PathVariable(value = "id") int id,@RequestBody Personel personel){
        return new ResponseEntity<>(personelService.updatePersonel(id, personel),HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(personelService.deletePersonel(id), HttpStatus.OK);
    }
}
