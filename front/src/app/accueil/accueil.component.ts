import { CommonModule, NgClass } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-accueil',
  standalone: true,
  imports: [ CommonModule],
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  userName: string = 'Invité';
  userRole: 'visiteur' | 'comptable' = 'visiteur'; // Valeur par défaut
  notifications = [
    { message: '2 fiches en attente de validation', type: 'alert' },
    { message: 'Votre dernier frais a été enregistré avec succès', type: 'info' }
  ];

  constructor(private router: Router) {}

  ngOnInit(): void {
    const storedUser = localStorage.getItem('user');
    if (storedUser) {
      const userData = JSON.parse(storedUser);
      this.userName = userData.login || 'Invité';
      this.userRole = userData.role || 'visiteur';
    }
  }

  navigateToDashboard() {
   
      this.router.navigate(['/visiteur-dashboard']);
  }

  navigateToFraisForm() {
    this.router.navigate(['/frais']);
  }

  navigateToFraisList() {
    this.router.navigate(['/liste-frais']);
  }
}