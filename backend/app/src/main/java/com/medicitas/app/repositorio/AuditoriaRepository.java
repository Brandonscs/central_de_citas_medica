package com.medicitas.app.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medicitas.app.modelo.Auditoria;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {

    @Query("SELECT a FROM Auditoria a WHERE a.tablaAfectada = :tabla")
    List<Auditoria> buscarAuditoriaPorTabla(String tabla);

    @Query("SELECT a FROM Auditoria a WHERE a.usuario.id = :idUsuario")
    List<Auditoria> buscarAuditoriaPorUsuario(Long idUsuario);

    @Query("SELECT a FROM Auditoria a WHERE a.accion = :accion")
    List<Auditoria> buscarAuditoriaPorAccion(String accion);

    @Query("SELECT a FROM Auditoria a WHERE DATE(a.fechaAccion) = DATE(:fecha)")
    List<Auditoria> buscarAuditoriaPorFecha(Date fecha);
    
    @Query("SELECT a FROM Auditoria a WHERE a.fechaAccion BETWEEN :inicio AND :fin")
    List<Auditoria> buscarAuditoriaPorRangoFecha(@Param("inicio") Date inicio, @Param("fin") Date fin);
}