import { Component, OnInit } from '@angular/core';
import { FraisService } from '../../services/frais.service';
import { UserService } from '../../services/user.service'; // ✅ AJOUT
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-frais-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './frais-list.component.html',
  styleUrls: ['./frais-list.component.css']
})
export class FraisListComponent implements OnInit {
  fraisList: any[] = [];

  constructor(
    private fraisService: FraisService,
    private userService: UserService // ✅ AJOUT
  ) {}

  ngOnInit() {
    const user = this.userService.getUser();

    if (!user) {
      alert("Aucun utilisateur connecté.");
      return;
    }

    this.fraisService.getFraisByVisiteurId(user.id).subscribe({
      next: (data) => {
        console.log('Frais récupérés pour utilisateur connecté :', data);
        this.fraisList = data;
      },
      error: (err) => {
        console.error('Erreur lors de la récupération des frais', err);
      }
    });
  }

  onDeleteFrais(frais: any) {
    if (confirm(`Voulez-vous vraiment supprimer ce frais du ${frais.date} ?`)) {
      this.fraisService.deleteFrais(frais.id).subscribe({
        next: () => {
          this.fraisList = this.fraisList.filter(item => item.id !== frais.id);
          console.log(`Frais du ${frais.date} supprimé avec succès.`);
        },
        error: (err) => {
          console.error('Erreur lors de la suppression :', err);
          alert(`Erreur lors de la suppression du frais : ${err.message}`);
        }
      });
    }
  }
}
