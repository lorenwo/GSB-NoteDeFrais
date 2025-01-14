import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class RoleGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(): boolean {
    const user = localStorage.getItem('user');
    if (user) {
      const parsedUser = JSON.parse(user);
      if (parsedUser.role === 'comptable') {
        return true; // Accès autorisé
      }
    }

    // Rediriger vers la page d'accueil si l'utilisateur n'est pas comptable
    this.router.navigate(['/Accueil']);
    return false;
  }
}