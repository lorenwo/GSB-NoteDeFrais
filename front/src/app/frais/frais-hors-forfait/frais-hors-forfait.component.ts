import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserService } from '../../services/user.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-frais-hors-forfait',
  standalone: true,
  templateUrl: './frais-hors-forfait.component.html',
  styleUrls: ['./frais-hors-forfait.component.css'],
  imports: [CommonModule, FormsModule]
})
export class FraisHorsForfaitComponent implements OnInit {
  fraisHorsForfait: any[] = [];

  constructor(private http: HttpClient, private userService: UserService, private router: Router) {}

  ngOnInit(): void {
    const user = this.userService.getUser();
    if (!user) {
      alert("Aucun utilisateur connecté.");
      return;
    }

    this.http.get<any[]>(`http://localhost:8080/api/fraisHorsForfait/visiteur/${user.id}`)
      .subscribe({
        next: (data) => {
          console.log("Frais hors forfait récupérés :", data);
          this.fraisHorsForfait = data;
        },
        error: (err) => {
          console.error("Erreur récupération frais hors forfait :", err);
        }
      });
  }

  onDeleteFraisHors(frais: any) {
    if (confirm(`Supprimer le frais du ${frais.date} ?`)) {
      this.http.delete(`http://localhost:8080/api/fraisHorsForfait/${frais.id}`).subscribe({
        next: () => {
          this.fraisHorsForfait = this.fraisHorsForfait.filter(f => f.id !== frais.id);
          console.log('Frais hors forfait supprimé avec succès.');
        },
        error: (err) => {
          console.error('Erreur lors de la suppression :', err);
        }
      });
    }
  }
  
  onEditFraisHors(frais: any) {
    this.router.navigate(['/frais-hors/modifier', frais.id]);
  }
  
}
