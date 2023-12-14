import { Component, OnInit } from '@angular/core';
import { SharedService } from 'app/shared.service';
import * as Chartist from 'chartist';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  Reservation= {
    prix:'',
    dateDebut:'',
    dateFin:'',
    duree:'',
    

  }
  commande= {
    date:'',
    etat:'',
   
    

  }
  commandes:any[] = [];

  searchedReservationId: number;

 

constructor(public shared: SharedService ){

}

ngOnInit(): void {
  // Initialiser searchedUniversiteId à une valeur par défaut ou laisser vide selon vos besoins
  this.searchedReservationId = 0; // ou null, ou toute autre valeur par défaut
  this.getCommandeList();
}

getReservationDetails(): void {
  this.shared.getReservationById(this.searchedReservationId).subscribe(
    (data) => {
      this.Reservation = data;
    },
    (error) => {
      console.error('Une erreur s\'est produite lors de la récupération des détails de l\'université : ', error);
    }
  );
}


deleteReservation(): void {
  

  if (!this.searchedReservationId) {
    console.error('ID de l\'université non défini. Impossible de supprimer.');
    return;
  }

  this.shared.deleteReservationById(this.searchedReservationId).subscribe(
    () => {
      console.log('Reservation supprimée avec succès ');
      // Rediriger l'utilisateur vers la liste des universités ou une autre page après la suppression
      
    },
    (error) => {
      console.error('Une erreur s\'est produite lors de la suppression de l\'Reservation : ', error);
    }
  );
}



  updateReservation(): void {
    // Supposons que vous ayez un objet d'université modifié dans votre composant
    
    this.shared.updateReservation({id : this.searchedReservationId ,...this.Reservation})
      .subscribe(
        (response) => {
          console.log('Reservation mise à jour avec succès :', response);
          // Traitez la réponse mise à jour ici si nécessaire
        },
        (error) => {
          console.error('Erreur lors de la mise à jour de l\'Reservation :', error);
        }
      );
  }

  getCommandeList(): void {
    this.shared.getCommandeList().subscribe(
      (data) => {
        this.commandes = data;
      },
      (error) => {
        console.error('Une erreur s\'est produite lors de la récupération des commande : ', error);
      }
    );
  }

  ajout(){
    this.shared.creatNewCommande(this.commande)
     .subscribe(
      res=>
      {
      console.log(res);
      },
      eur=>
      {
      console.log(eur);
      }
     )
  
    }
   

}
