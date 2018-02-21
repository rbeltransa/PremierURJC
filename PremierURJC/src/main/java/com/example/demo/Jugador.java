package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Jugador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nombreJugador;
	private String equipoJugador;
	private String posicion;
	private int edad;
	private String nacionalidadJugador;
	private long valorMercado;

	@ManyToOne
	private Equipo equipo;

	public Jugador() {

	}

	public Jugador(String nombreJugador, String equipoJugador, String posicion, int edad, String nacionalidadJugador,
			long valorMercado) {
		this.nombreJugador = nombreJugador;
		this.equipoJugador = equipoJugador;
		this.posicion = posicion;
		this.edad = edad;
		this.nacionalidadJugador = nacionalidadJugador;
		this.valorMercado = valorMercado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public String getEquipoJugador() {
		return equipoJugador;
	}

	public void setEquipoJugador(String equipoJugador) {
		this.equipoJugador = equipoJugador;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNacionalidadJugador() {
		return nacionalidadJugador;
	}

	public void setNacionalidadJugador(String nacionalidadJugador) {
		this.nacionalidadJugador = nacionalidadJugador;
	}

	public long getValorMercado() {
		return valorMercado;
	}

	public void setValorMercado(long valorMercado) {
		this.valorMercado = valorMercado;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombreJugador=" + nombreJugador + ", equipoJugador=" + equipoJugador
				+ ", posicion=" + posicion + ", edad=" + edad + ", nacionalidadJugador=" + nacionalidadJugador
				+ ", valorMercado=" + valorMercado + ", equipo=" + equipo + "]";
	}

}
