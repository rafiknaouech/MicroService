package com.esprit.microservice.gestioncmmande.gestioncommande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface Commanderep extends JpaRepository <Commande, Integer> {
   /* @Query("select c from Commande c where c.modePaiement like :m")
    public Page<Commande> commandeByModePaiement(@Param("m") String mp, Pageable pageable);*/
    @Query("SELECT c FROM Commande c WHERE  c.idClient = :idClient")
    public Page<Commande> commandeByClientId( @Param("idClient") int idClient, Pageable pageable);
   /* @Query("select c from Candidat c where c.nom like :name").
    public Page<Candidat> candidatByNom(@Param("name") String n, Pageable pageable);
  http://localhost:8081/commandes/search/commandeByModePaiement?m=Carte
*/
  /* @Query("SELECT c FROM Commande c WHERE c.modePaiement like :m")
   Page<Commande> commandeByModePaiement(@Param("m") String m, Pageable pageable);*/

}