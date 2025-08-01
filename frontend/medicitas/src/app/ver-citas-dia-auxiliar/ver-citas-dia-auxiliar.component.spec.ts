import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerCitasDiaAuxiliarComponent } from './ver-citas-dia-auxiliar.component';

describe('VerCitasDiaAuxiliarComponent', () => {
  let component: VerCitasDiaAuxiliarComponent;
  let fixture: ComponentFixture<VerCitasDiaAuxiliarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerCitasDiaAuxiliarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VerCitasDiaAuxiliarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
