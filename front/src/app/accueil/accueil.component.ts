import { CommonModule, NgClass } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-accueil',
  standalone: true,
  imports: [NgClass, CommonModule],
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  userName: string | null = null;
  userRole: 'visiteur' | 'comptable' | null = null;
  notifications = [
    { message: '2 fiches en attente de validation', type: 'alert' },
    { message: 'Votre dernier frais a été enregistré avec succès', type: 'info' }
  ];

  constructor(private router: Router) {}

  ngOnInit(): void {
    const user = localStorage.getItem('user');
    if (user) {
      const parsedUser = JSON.parse(user);
      this.userName = parsedUser.name;
      this.userRole = parsedUser.role || 'visiteur';
    } else {
      this.router.navigate(['/login']); // Redirige vers la page de login si pas d'utilisateur
    }
  }

  navigateToValidation() {
    if (this.userRole === 'comptable') {
      this.router.navigate(['/valide-frais']);
    }
  }

  navigateToDashboard() {
    if (this.userRole === 'visiteur') {
      this.router.navigate(['/visiteur-dashboard']);
    } else if (this.userRole === 'comptable') {
      this.router.navigate(['/comptable-dashboard']);
    }
  }

  navigateToFraisForm() {
    this.router.navigate(['/frais']);
  }



  navigateToFraisList() {
    this.router.navigate(['/liste-frais']);
  }

  logout() {
    // Supprimer l'utilisateur du localStorage pour la déconnexion
    localStorage.removeItem('user');
    this.router.navigate(['/login']);
  }
}