import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-support',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './support.component.html',
  styleUrls: ['./support.component.css']
})
export class SupportComponent {}
