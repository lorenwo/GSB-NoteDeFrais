import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FraisService } from '../../services/frais.service';
import { Router } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-frais-form',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  providers: [FraisService],
  templateUrl: './frais-form.component.html',
  styleUrls: ['./frais-form.component.css']
})
export class FraisFormComponent {

  private readonly router = inject(Router);

  frais = {
    visiteurId: '',
    date: '',
    type: '',
    kilometres: 0,
    montant: 0,
    description: '',
    amount: null
  };

  typesFrais = ['Repas midi', 'Relais étape', 'Nuitée', 'Kilométrage'];

  constructor(private fraisService: FraisService) {}

  // Appelé lors de la soumission du formulaire
  onSubmit() {
    this.fraisService.addFrais({ ...this.frais }).subscribe(
      response => {
        alert('Frais enregistré avec succès !');
        this.router.navigate(['/liste-frais']);
      },
      error => {
        console.error("Erreur lors de l'enregistrement des frais", error);
        alert("Une erreur est survenue lors de l'enregistrement des frais.");
      }
    );
  }

  // Réinitialiser le formulaire
  resetForm() {
    this.frais = {
      visiteurId: '',
      date: '',
      type: '',
      kilometres: 0,
      montant: 0,
      description: '',
      amount: null
    };
  }
}