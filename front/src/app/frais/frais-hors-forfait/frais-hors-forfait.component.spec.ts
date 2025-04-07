import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FraisHorsForfaitComponent } from './frais-hors-forfait.component';

describe('FraisHorsForfaitComponent', () => {
  let component: FraisHorsForfaitComponent;
  let fixture: ComponentFixture<FraisHorsForfaitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FraisHorsForfaitComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FraisHorsForfaitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
