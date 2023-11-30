package com.esprit.microservice.gestioncmmande.gestioncommande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    @Autowired
    private Commanderep commanderep;

    public List<Commande> getAllCommandes() {
        return commanderep.findAll();
    }
  /*  public Commande getCommandeById(int id) {
        Optional<Commande> optionalCommande = commanderep.findById(id);
        return optionalCommande.orElse(null);
    }*/
  public Commande getCommandeById(int id){
      return commanderep.findById(id).get();
  }

    public Commande addCommande(Commande commande) {
        return commanderep.save(commande);
    }

    public Commande updateCommande(int id, Commande newCommande) {
        if (commanderep.findById(id).isPresent()) {
            Commande existingCommande = commanderep.findById(id).get();
            // Mise à jour des attributs selon les besoins
            existingCommande.setId(newCommande.getId());
            existingCommande.setEtat(newCommande.getEtat());
            existingCommande.setDateCommande(newCommande.getDateCommande());

            return commanderep.save(existingCommande);
        } else {
            return null;
        }

    }

    public String deleteCommande(int id) {
        if (commanderep.findById(id).isPresent()) {
            commanderep.deleteById(id);
            return "Commande supprimée";
        } else {
            return "Commande non supprimée";
        }
    }
  /*  public List<Commande> getcommandeByModePaiement(String modePaiement) {
        return commanderep.commandeByModePaiement (modePaiement,PageRequest.of(0, 10)).getContent();
    }*/
}
