package com.esprit.microservice.gestioncmmande.gestioncommande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CommandeRestAPI {
    private String title="Hello, im the candidate MIcro Service";
    @RequestMapping("")
    public String sayHello(){
        System.out.println(title);
        return title;
    }

    @Autowired
    private CommandeService commandeService;

    @GetMapping("/commandes")
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

  /*  @GetMapping("/commandes/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable int id) {
        Commande commande = commandeService.getCommandeById(id);
        if (commande != null) {
            return new ResponseEntity<>(commande, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/
  @GetMapping("/commandebyid/{id}")
  public ResponseEntity<Commande> getCommandeById(@PathVariable int id) {
      Commande commande = commandeService.getCommandeById(id);

      if (commande != null) {
          return ResponseEntity.ok().body(commande);
      } else {
          return ResponseEntity.notFound().build();
      }
  }

   //@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addcommande")
    public ResponseEntity<Commande> createCommande(@RequestBody Commande commande) {
        return new ResponseEntity<>(commandeService.addCommande(commande), HttpStatus.CREATED);
    }

    @PutMapping(value = "/updatecommande", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Commande> updateCommande(@PathVariable(value = "id") int id, @RequestBody Commande commande) {
        return new ResponseEntity<>(commandeService.updateCommande(id, commande), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletecommande", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCommande(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(commandeService.deleteCommande(id), HttpStatus.OK);
    }
}