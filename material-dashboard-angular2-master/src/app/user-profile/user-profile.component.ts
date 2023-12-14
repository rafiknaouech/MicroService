import { Component, OnInit } from '@angular/core';
import { SharedService } from 'app/shared.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  Reservation= {
    prix:'',
    dateDebut:'',
    dateFin:'',
    duree:'',
    

  }

  searchedReservationId: number;




  reservations: any[] = [];

  

 

  getUniversitesList(): void {
    this.shared.getReservationList().subscribe(
      (data) => {
        this.reservations = data;
      },
      (error) => {
        console.error('Une erreur s\'est produite lors de la récupération des universités : ', error);
      }
    );
  }
ajout(){
  this.shared.creatNewReservation(this.Reservation)
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
 

constructor(public shared: SharedService ){

}

ngOnInit(): void {
  // Initialiser searchedUniversiteId à une valeur par défaut ou laisser vide selon vos besoins
  this.searchedReservationId = 0; // ou null, ou toute autre valeur par défaut
  this.getUniversitesList();
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
}
