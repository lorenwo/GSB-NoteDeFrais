import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { FraisListComponent } from './frais/frais-list/frais-list.component';
import { FraisFormComponent } from './frais/frais-form/frais-form.component';
import { AccueilComponent } from './accueil/accueil.component'; // Importez le composant Accueil
import { StatistiqueComponent } from './statistique/statistique.component';
import { SupportComponent } from './support/support.component';
import { FraisHorsForfaitComponent } from './frais/frais-hors-forfait/frais-hors-forfait.component';


export const routes: Routes = [
    { path: '', redirectTo: 'Accueil', pathMatch: 'full' }, // Redirection vers 'accueil' par défaut
    { path: 'Accueil', component: AccueilComponent }, // Route pour la page d'accueil
    { path: 'login', component: LoginComponent },
    { path: 'liste-fraisForfait', component: FraisListComponent },
    { path: 'frais/modifier/:id', component: FraisFormComponent }, // forfait
    { path: 'frais-hors/modifier/:id', component: FraisFormComponent }, // hors forfait
    { path: 'frais', component: FraisFormComponent },
    { path: 'statistique', component: StatistiqueComponent},
    { path: 'support', component: SupportComponent},
    { path: 'liste-fraisHorsForfait', component: FraisHorsForfaitComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }