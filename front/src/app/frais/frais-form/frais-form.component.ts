import { CommonModule } from '@angular/common';
import { Component, OnInit, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FraisService } from '../../services/frais.service';
import { Router, ActivatedRoute  } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { UserService } from '../../services/user.service';


@Component({
  selector: 'app-frais-form',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  providers: [FraisService],
  templateUrl: './frais-form.component.html',
  styleUrls: ['./frais-form.component.css']
})
export class FraisFormComponent implements OnInit {
  frais: any = {
    visiteur: {},
    date: '',
    typeFrais: '',
    kilometres: '',
    montant: 0,
    description: ''
  };

  typesFrais = ['Repas midi', 'Relais étape', 'Nuitée', 'Kilométrage', 'Hors forfait'];

  isUpdate = false;
  isHorsForfait = false;

  constructor(
    private fraisService: FraisService,
    private router: Router,
    private userService: UserService,
    private route: ActivatedRoute,
    private http: HttpClient
  ) {}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isUpdate = true;
      this.isHorsForfait = this.router.url.includes('frais-hors');
  
      const url = this.isHorsForfait
        ? `http://localhost:8080/api/fraisHorsForfait/${id}`
        : `http://localhost:8080/api/fraisForfait/${id}`;
  
      this.http.get(url).subscribe((frais: any) => {
        this.frais = frais;
      });
    }
  }

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
  
    if (this.frais.typeFrais === 'Kilométrage') {
      const km = parseFloat(this.frais.kilometres as any);
      this.frais.montant = !isNaN(km) ? km * 0.2 : 0;
    }
  
    if (this.isUpdate) {
      const url = this.isHorsForfait
        ? `http://localhost:8080/api/fraisHorsForfait/${this.frais.id}`
        : `http://localhost:8080/api/fraisForfait/${this.frais.id}`;
  
      this.http.put(url, this.frais).subscribe(() => {
        const redir = this.isHorsForfait ? '/liste-fraisHorsForfait' : '/liste-fraisForfait';
        this.router.navigate([redir]);
      });
  
    } else {
      this.fraisService.addFrais(this.frais).subscribe((response: any) => {
        const redirectUrl = (response && response.id)
          ? '/liste-fraisForfait'
          : '/liste-fraisHorsForfait';
  
        this.router.navigate([redirectUrl]);
      });
    }
  }
  
  
  

  goToListForfait() {
    this.router.navigate(['/liste-fraisForfait']);
  }
}