package com.microservices.reclamation.controller;

import com.microservices.reclamation.Service.ReclamationService;
import com.microservices.reclamation.entity.Reclamation;
import com.microservices.reclamation.repository.ReclamationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReclamationRestAPI {
    private String title="Hello, i'm condidat Micro Service";
    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println(title);
        return title;
    }
    @Autowired
    private ReclamationRepository reclamationRepository;
    @GetMapping("/reclamations")
    public List<Reclamation> getAllReclamations(){return reclamationRepository.findAll();}
    @Autowired
    private ReclamationService reclamationService;
    @PostMapping(value="/add" ,consumes = org.springframework.http.MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Reclamation> createReclamation(@RequestBody Reclamation reclamation){
        return new ResponseEntity<>(reclamationService.addReclamation(reclamation),HttpStatus.OK);

    }
    @PutMapping(value = "/'{id}",produces= org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Reclamation> updateReclamation(@PathVariable(value="id")int id,@RequestBody Reclamation reclamation){
        return new ResponseEntity<>(reclamationService.updateReclamation(id,reclamation),HttpStatus.OK);
    }
    @DeleteMapping(value  ="/{id}",produces  = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteReclamation(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(reclamationService.deletReclamation(id),HttpStatus.OK);
    }

}
