import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  constructor(private httpClient: HttpClient) {

  }
  private url = 'http://localhost:8093';
  
 

 Reservation: any[] = [];
 creatNewReservation(Reservation: any){
  return this.httpClient.post(this.url + '/add',Reservation)
 }
 getReservationList(): Observable<any[]> {
   return this.httpClient.get<any[]>(this.url + '/reservation');
 }
 getReservationById(id: number): Observable<any> {
   return this.httpClient.get<any>(`${this.url}/reservations/${id}`);
}

deleteReservationById(id: number): Observable<any> {
 return this.httpClient.delete<any>(`${this.url}/delete/${id}`);
}


updateReservation(updatedData: any): Observable<any> {
 return this.httpClient.put<any>(`${this.url}/update/`, updatedData);
}



Commande: any[]=[];
getCommandeList(): Observable<any[]> {
  return this.httpClient.get<any[]>(this.url + '/commandes');

}
creatNewCommande(Cammande: any){
  return this.httpClient.post(this.url + '/addcommande',Cammande)
 }

}
