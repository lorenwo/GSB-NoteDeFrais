import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { FraisListComponent } from './frais/frais-list/frais-list.component';
import { FraisFormComponent } from './frais/frais-form/frais-form.component';
import { AccueilComponent } from './accueil/accueil.component'; // Importez le composant Accueil
import { ValidationFraisComponent } from './validation-frais/validation-frais.component';
import { RoleGuard } from './guards/auth.guards';


export const routes: Routes = [
    { path: '', redirectTo: 'Accueil', pathMatch: 'full' }, // Redirection vers 'accueil' par défaut
    { path: 'Accueil', component: AccueilComponent }, // Route pour la page d'accueil
    { path: 'login', component: LoginComponent },
    { path: 'liste-frais', component: FraisListComponent },
    { path: 'frais', component: FraisFormComponent },
    { path: 'valide-frais', component: ValidationFraisComponent, canActivate: [RoleGuard]},
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }