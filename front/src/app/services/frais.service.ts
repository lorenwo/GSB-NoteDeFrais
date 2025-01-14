import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

type TypeFrais = 'Repas midi' | 'Relais étape' | 'Nuitée' | 'Kilométrage';

const FORFAITS: Record<TypeFrais, number> = {
  'Repas midi': 20,
  'Relais étape': 100,
  'Nuitée': 80,
  'Kilométrage': 0.5
};

@Injectable({
  providedIn: 'root'
})
export class FraisService {
  private fraisList: any[] = [];

  constructor() {
    this.loadFraisFromLocalStorage();
  }

  private saveFraisToLocalStorage() {
    localStorage.setItem('fraisList', JSON.stringify(this.fraisList));
  }

  private loadFraisFromLocalStorage() {
    const savedFrais = localStorage.getItem('fraisList');
    this.fraisList = savedFrais ? JSON.parse(savedFrais) : [];
  }

  addFrais(frais: any): Observable<any> {
    if (frais.type in FORFAITS) {
      frais.montant = FORFAITS[frais.type as TypeFrais] * (frais.type === 'Kilométrage' ? frais.kilometres : 1);
    }
    this.fraisList.push(frais);
    this.saveFraisToLocalStorage(); // Sauvegarder les frais dans le localStorage
    return of(frais);
  }

  getFrais(): Observable<any[]> {
    return of(this.fraisList);
  }
}