import { Component, OnInit } from '@angular/core';

declare const $: any;
declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
    { path: '/dashboard', title: 'Commande',  icon: 'dashboard', class: '' },
    { path: '/user-profile', title: 'Reservation',  icon:'person', class: '' },
    { path: '/table-list', title: 'Stock',  icon:'content_paste', class: '' },
    { path: '/typography', title: 'Personel',  icon:'library_books', class: '' },
    { path: '/icons', title: 'Reclamation',  icon:'bubble_chart', class: '' },
    { path: '/maps', title: '',  icon:'', class: '' },
    { path: '/notifications', title: '',  icon:'', class: '' },
    { path: '/upgrade', title: '',  icon:'', class: 'active-pro' },
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
      if ($(window).width() > 991) {
          return false;
      }
      return true;
  };
}
