import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FraisService } from "../services/frais.service"

@Component({
  selector: 'app-statistique',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './statistique.component.html',
  styleUrls: ['./statistique.component.css']
})
export class StatistiqueComponent implements OnInit {

  visiteursSansFraisHors: any[] = [];

  constructor(private fraisService: FraisService) {}

  ngOnInit(): void {
    this.chargerVisiteursSansFraisHors();
  }

  chargerVisiteursSansFraisHors(): void {
    this.fraisService.getVisiteursSansFraisHorsForfait().subscribe({
      next: data => {
        this.visiteursSansFraisHors = data;
        console.log("Visiteurs sans frais hors forfait :", data);
      },
      error: err => {
        console.error("Erreur récupération visiteurs :", err);
      }
    });
  }
}
