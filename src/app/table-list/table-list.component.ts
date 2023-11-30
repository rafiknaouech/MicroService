import { Component, OnInit } from '@angular/core';
import { SharedService } from 'app/shared.service';

@Component({
  selector: 'app-table-list',
  templateUrl: './table-list.component.html',
  styleUrls: ['./table-list.component.css']
})
export class TableListComponent implements OnInit {

  reservations: any[] = [];

  constructor(public shared:SharedService ) { }

  ngOnInit(): void {
    this.getUniversitesList();
  }

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
  

}
