import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FraisService } from '../../services/frais.service';
import { Router } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { UserService } from '../../services/user.service';


@Component({
  selector: 'app-frais-form',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  providers: [FraisService],
  templateUrl: './frais-form.component.html',
  styleUrls: ['./frais-form.component.css']
})
export class FraisFormComponent {
  frais = {
    visiteur: {},
    date: '',
    typeFrais: '',
    kilometres: '',
    montant: 0,
    description: ''
  };

  typesFrais = ['Repas midi', 'Relais étape', 'Nuitée', 'Kilométrage', 'Hors forfait'];

  constructor(
    private fraisService: FraisService,
    private router: Router,
    private userService: UserService
  ) {}

  // 🔁 Mettre à jour automatiquement le montant si type = Kilométrage
  onTypeFraisChange() {
    if (this.frais.typeFrais === 'Kilométrage') {
      this.updateMontantKilometrique();
    }
  }

  onKilometresChange() {
    if (this.frais.typeFrais === 'Kilométrage') {
      this.updateMontantKilometrique();
    }
  }

  updateMontantKilometrique() {
    const km = parseFloat(this.frais.kilometres as any);
    this.frais.montant = !isNaN(km) ? km * 0.2 : 0;
  }

  onSubmit() {
    const currentUser = this.userService.getUser();
  
    if (!currentUser) {
      alert("Aucun utilisateur connecté.");
      return;
    }
  
    this.frais.visiteur = { id: currentUser.id };
  
    // 🔁 Cas Kilométrage : recalculer le montant
    if (this.frais.typeFrais === 'Kilométrage') {
      const km = parseFloat(this.frais.kilometres as any);
      this.frais.montant = !isNaN(km) ? km * 0.2 : 0;
    }
  
    console.log('Frais à enregistrer :', this.frais);
  
    this.fraisService.addFrais(this.frais).subscribe({
      next: (response: any) => {
        console.log("Frais ajouté :", response);
  
        // 🔀 Redirection dynamique en fonction du type + montant
        const type = this.frais.typeFrais;
        const montant = this.frais.montant;
  
        // 🔎 On définit si ça doit être considéré "hors forfait"
        const isHorsForfait = (
          (type === 'Repas midi' && montant > 25) ||
          (type === 'Nuitée' && montant > 100) ||
          (type === 'Relais étape' && montant > 150)
        );
  
        if (isHorsForfait || type === 'Hors forfait') {
          this.router.navigate(['/liste-fraisHorsForfait']);
        } else {
          this.router.navigate(['/liste-fraisForfait']);
        }
      },
      error: (err) => {
        console.error("Erreur lors de l'ajout du frais :", err);
      }
    });
  }
  

  goToListForfait() {
    this.router.navigate(['/liste-fraisForfait']);
  }
}