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
    visiteur: {}, // sera défini dynamiquement
    date: '',
    typeFrais: '',
    kilometres: '',
    montant: 0,
    description: ''
  };
  

  typesFrais = ['Repas midi', 'Relais étape', 'Nuitée', 'Kilométrage', 'Hors forfait'];

  constructor(private fraisService: FraisService, private router: Router,  private userService: UserService ) {}

  onSubmit() {
    const currentUser = this.userService.getUser();
  
    if (!currentUser) {
      alert("Aucun utilisateur connecté.");
      return;
    }
  
    // Attribue le visiteur automatiquement
    this.frais.visiteur = {
      id: currentUser.id
    };
  
    console.log('Requête envoyée au backend :', this.frais);
  
    this.fraisService.addFrais(this.frais).subscribe(
      response => {
        console.log('Frais ajouté avec succès');
        this.goToListForfait();
      },
      error => {
        console.error('Erreur lors de l\'ajout du frais', error);
      }
    );
  }

  public goToListForfait() {
    this.router.navigate(['/liste-frais']);
  }
}
