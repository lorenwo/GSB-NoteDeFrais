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
  name: string = '';
  password: string = '';
  role: 'visiteur' | 'comptable' = 'visiteur'; // Rôle par défaut

  constructor(private router: Router, private userService: UserService) {}

  onSubmit(): void {
    if (this.name.trim() && this.password.trim()) {
      const role = this.role;
      localStorage.setItem(
        'user',
        JSON.stringify({ name: this.name, role: this.role })
      );

      // Met à jour le rôle dans le service utilisateur
      this.userService.setUserRole(role);

      alert('Connexion réussie!');
      this.router.navigate(['/Accueil']);
    } else {
      alert('Veuillez remplir tous les champs.');
    }
}
}