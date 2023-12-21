import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharddService {
  Commande: any[] = [];
  constructor(private httpClient: HttpClient) { }

  private url = 'http://localhost:8093';

  getCommandeList(): Observable<any[]> {
    return this.httpClient.get<any[]>(this.url + '/commandes');

}
}