package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioEquipo extends JpaRepository<Equipo, Long> {

	List<Equipo> findDistinctEquiposByLigaOrderByNombreEquipoAsc(String liga);

	List<Equipo> findDistinctEquiposByLigaOrderByNumTorneoGanadosDesc(String liga);

	Equipo findByNombreEquipo(String nombreEquipo);

}
