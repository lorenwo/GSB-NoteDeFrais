import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink, RouterOutlet } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterLink,RouterOutlet],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent {

  isCollapsed = false;
  userRole: string | null = null;

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.userService.userRole$.subscribe((role) => {
      this.userRole = role;
    });
  }

  toggleSidebar() {
    this.isCollapsed = !this.isCollapsed;
  }
}