import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerCitasUsuarioComponent } from './ver-citas-usuario.component';

describe('VerCitasUsuarioComponent', () => {
  let component: VerCitasUsuarioComponent;
  let fixture: ComponentFixture<VerCitasUsuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerCitasUsuarioComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VerCitasUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
