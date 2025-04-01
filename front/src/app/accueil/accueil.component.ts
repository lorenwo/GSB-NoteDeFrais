import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { UserService } from '../services/user.service'; // adapte le chemin selon ton projet
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-accueil',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  userName: string = 'Invité';

  constructor(private router: Router, private userService: UserService) {}

  ngOnInit(): void {
    const user = this.userService.getUser();
    if (user) {
      this.userName = user.login;
    }
  }

  logout(): void {
    this.userService.logout();
    this.router.navigate(['/login']);
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
