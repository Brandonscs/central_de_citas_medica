import { TestBed } from '@angular/core/testing';

import { RolUsuariosService } from './rol-usuarios.service';

describe('RolUsuariosService', () => {
  let service: RolUsuariosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RolUsuariosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
