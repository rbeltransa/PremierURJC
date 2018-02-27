package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Entrenador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nombreEntrenador;
	private String equipoEntrenador;
	private String user;
	private String password;

	@OneToOne
	private Equipo equipo;

	@OneToMany
	private List<Jugador> jugadores;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

	public Entrenador() {
	}

	public Entrenador(String nombreEntrenador, String equipoEntrenador, String user, String password, String rol) {
		this.nombreEntrenador = nombreEntrenador;
		this.equipoEntrenador = equipoEntrenador;
		this.user = user;
		this.password = new BCryptPasswordEncoder().encode(password);
		this.roles = new ArrayList<String>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreEntrenador() {
		return nombreEntrenador;
	}

	public void setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = nombreEntrenador;
	}

	public String getEquipoEntrenador() {
		return equipoEntrenador;
	}

	public void setEquipoEntrenador(String equipoEntrenador) {
		this.equipoEntrenador = equipoEntrenador;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	public List<String> getRoles(){
		return roles;
	}
	
	public void setRoles(List<String> roles){
		this.roles = roles;
	}
	
	@Override
	public String toString() {
		return "Entrenador [id=" + id + ", nombreEntrenador=" + nombreEntrenador + ", equipoEntrenador=" + equipoEntrenador + ", user="
				+ user + ", password=" + password + ", equipo=" + equipo + ", jugadores=" + jugadores + "]";
	}

}
