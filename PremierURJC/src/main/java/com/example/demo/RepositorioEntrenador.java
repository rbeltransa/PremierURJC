package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioEntrenador extends JpaRepository<Entrenador, Long> {

	Entrenador findByUserAndPassword(String user, String password);
	Entrenador findByUser(String user);
}
