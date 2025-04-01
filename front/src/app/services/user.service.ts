import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

export interface Visiteur {
  id: number;
  login: string;
  mdp: string;
}

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private apiUrl = 'http://localhost:8080/api/visiteur/login';
  private http = inject(HttpClient);
  private currentUser: Visiteur | null = null;

  login(userData: { login: string; mdp: string }): Observable<Visiteur> {
    return this.http.post<Visiteur>(this.apiUrl, userData).pipe(
      tap(user => this.setUser(user))
    );
  }

  setUser(user: Visiteur): void {
    this.currentUser = user;
    if (typeof window !== 'undefined') {
      localStorage.setItem('currentUser', JSON.stringify(user));
    }
  }

  getUser(): Visiteur | null {
    if (this.currentUser) return this.currentUser;
  
    // ✅ Vérifie que window/localStorage existent (navigateur uniquement)
    if (typeof window !== 'undefined' && localStorage.getItem('currentUser')) {
      this.currentUser = JSON.parse(localStorage.getItem('currentUser')!);
    }
  
    return this.currentUser;
  }

  logout(): void {
    this.currentUser = null;
    if (typeof window !== 'undefined') {
      localStorage.removeItem('currentUser');
    }
  }
}
