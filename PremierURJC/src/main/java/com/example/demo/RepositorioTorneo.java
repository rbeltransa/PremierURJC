package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTorneo extends JpaRepository<Torneo, Long> {

	Torneo findByNombreLiga(String nombreLiga);

}
