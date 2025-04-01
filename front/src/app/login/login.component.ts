import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  login: string = '';
  mdp: string = '';
  errorMessage: string | null = null;

  constructor(private router: Router, private userService: UserService) {}

  onSubmit(): void {
    this.errorMessage = null;
  
    if (!this.login.trim() || !this.mdp.trim()) {
      this.errorMessage = 'Veuillez remplir tous les champs.';
      return;
    }
  
    this.userService.login({ login: this.login, mdp: this.mdp }).subscribe({
      next: () => {
        this.router.navigate(['/Accueil']);
      },
      error: () => {
        this.errorMessage = 'Identifiants invalides.';
      }
    });
  }
  
}
