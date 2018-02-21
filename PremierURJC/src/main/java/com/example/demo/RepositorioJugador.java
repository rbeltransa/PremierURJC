package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioJugador extends JpaRepository<Jugador, Long> {

	Jugador findByNombreJugador(String nombreJugador);

	List<Jugador> findByEdad(int edad);

	List<Jugador> findByNacionalidadJugador(String nacionalidadJugador);

	List<Jugador> findDistinctJugadoresByEquipoJugadorOrderByValorMercadoDesc(String equipoJugador);

	List<Jugador> findDistinctJugadoresByNacionalidadJugadorOrderByValorMercadoDesc(String nacionalidadJugador);

	List<Jugador> findDistinctJugadoresByEdadOrderByValorMercadoDesc(int edad);

}
