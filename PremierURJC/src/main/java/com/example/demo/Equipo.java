package com.example.demo;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nombreEquipo;
	private String liga;
	private String nacionalidadEquipo;
	private int numTorneoGanados;
	
	@OneToMany(mappedBy="equipo")
	private List<Jugador> jugadores;
	
	@ManyToOne
	private Palmares palmares;	
	
	@ManyToOne
	private Torneo torneo;
	
	public Equipo(){
	}
	
	public Equipo (String nombreEquipo, String liga, String nacionalidadEquipo, int numTorneoGanados){
		this.nombreEquipo = nombreEquipo;
		this.liga = liga;
		this.nacionalidadEquipo = nacionalidadEquipo;
		this.numTorneoGanados = numTorneoGanados;		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getLiga() {
		return liga;
	}

	public void setLiga(String liga) {
		this.liga = liga;
	}

	public String getNacionalidadEquipo() {
		return nacionalidadEquipo;
	}

	public void setNacionalidadEquipo(String nacionalidadEquipo) {
		this.nacionalidadEquipo = nacionalidadEquipo;
	}

	public int getNumTorneoGanados() {
		return numTorneoGanados;
	}

	public void setNumTorneoGanados(int numTorneoGanados) {
		this.numTorneoGanados = numTorneoGanados;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Palmares getPalmares() {
		return palmares;
	}

	public void setPalmares(Palmares palmares) {
		this.palmares = palmares;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombreEquipo=" + nombreEquipo + ", liga=" + liga + ", nacionalidadEquipo="
				+ nacionalidadEquipo + ", numTorneoGanados=" + numTorneoGanados + ", jugadores=" + jugadores
				+ ", palmares=" + palmares + ", torneo=" + torneo + "]";
	}
}
