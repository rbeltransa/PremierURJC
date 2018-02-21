package com.example.demo;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrermierURJCController {

	// Inyectamos los repositorios.
	@Autowired
	private RepositorioTorneo torneoRepository;
	@Autowired
	private RepositorioEquipo equipoRepository;
	@Autowired
	private RepositorioJugador jugadorRepository;
	@Autowired
	private RepositorioEntrenador entrenadorRepository;
	@Autowired
	private RepositorioPalmares palmaresRepository;

	// User y Password Compartidas HttpSession
	String userCompartida;
	String passwordCompartida;

	@PostConstruct
	// Indicamos los torneos, equipos y jugadores añadidos por defecto al ejecutarse
	// el programa.
	public void predeterminado() {
		// Generamos los siguientes Torneos, Equipos, Jugadores y Entrenadores únicamente la
		// primera vez que se
		// ejecuta la app. Las demás veces, como ya están cargado los datos
		// (persistencia), los comentamos.

		// //Creamos los Torneos.
		Torneo lnfs = new Torneo("LNFS",20);
		Torneo copa = new Torneo("Copa del Rey",20);
		
		
		 torneoRepository.save(lnfs);
		 torneoRepository.save(copa);
		
		//Creamos los Equipos de la LNFS.
		Equipo interMovistar = new Equipo("Inter Movistar","LNFS","España",50);
	    Equipo barcelona = new Equipo("Barcelona","LNFS","España",32);
		
	    Equipo pozo = new Equipo("El Pozo","Copa del Rey","España",10);
	    Equipo laSerna = new Equipo("U.D La Serna","Copa del Rey","España",15);
		
		
		interMovistar.setTorneo(lnfs);
		barcelona.setTorneo(lnfs);
		
		pozo.setTorneo(copa);
		laSerna.setTorneo(copa);
		
		
		//Guardamos los equipos en el repositorio de equipos
		equipoRepository.save(interMovistar);
		equipoRepository.save(barcelona);
		equipoRepository.save(pozo);
		equipoRepository.save(laSerna);

	
		
		
		//Creamos los jugadores.
	
		Jugador ricardinho = new Jugador("Ricardo Filipe Da Silva Braga","Inter Movistar","Ala",32,"Portugal",60000000);
		Jugador bebe = new Jugador("Rafael García Aguilera","Inter Movistar","Cierre",28,"España",20000000);
		
		Jugador sedano = new Jugador("Paco Sedano ","Barcelona","Portero",38,"España",40000000);
		Jugador leonardo = new Jugador("Leonardo Santana Da Silva ","Barcelona ","Cierre",30,"Brasil",20000000);
		
		Jugador elias = new Jugador("Elías Beltrán Fernández","El Pozo","Ala",25,"España",30000000);
		Jugador manuel = new Jugador("Manuel Piqueras Dólera","El Pozo","Cierre",18,"España",10000000);
		
		Jugador ruben = new Jugador("Rubén Beltrán Sánchez","U.D La Serna","Cierre",25,"España",30000000);
		Jugador david = new Jugador("David Beltrán Sánchez","U.D La Serna","Cierre",25,"España",30000000);
		

		ricardinho.setEquipo(interMovistar);
	    bebe.setEquipo(interMovistar);
		sedano.setEquipo(barcelona);
		leonardo.setEquipo(barcelona);
		elias.setEquipo(pozo);
		manuel.setEquipo(pozo);
		ruben.setEquipo(laSerna);
		david.setEquipo(laSerna);
	    
		
		//Guardamos los jugadores en el repositorio de jugadores
		
		jugadorRepository.save(ricardinho);
		jugadorRepository.save(bebe);
		jugadorRepository.save(sedano);
		jugadorRepository.save(leonardo);
		jugadorRepository.save(elias);
		jugadorRepository.save(manuel);
		jugadorRepository.save(ruben);
		jugadorRepository.save(david);
		
		
		// //Creamos los entrenadores de los equipos
		Entrenador eduardo = new Entrenador("Eduardo Sao","El Pozo","edu","pozo");
		eduardo.setEquipo(pozo);
		entrenadorRepository.save(eduardo);
		
	
		Entrenador jesus = new Entrenador("Jesús Velasco","Inter Movistar","jesus","movistar");
		eduardo.setEquipo(interMovistar);
		entrenadorRepository.save(jesus);
		
		
		Entrenador plaza = new Entrenador("Andreu Plaza","Barcelona","plaza","bcn");
		eduardo.setEquipo(barcelona);
		entrenadorRepository.save(plaza);
		
	
		Entrenador miguel = new Entrenador("Miguel Angel Beltran","U.D La Serna","ma","serna");
		eduardo.setEquipo(laSerna);
		entrenadorRepository.save(miguel);
		
	}

	// Indicamos la página principal de nuestra aplicación Web.
	@RequestMapping("/")
	public String principal() {
		return "index";
	}

	// Parte pública de nuestra aplicación Web donde se van a realizar las
	// consultas.
	@RequestMapping("/realizarconsultas")
	public String realizarConsultas() {
		return "realizarconsultas";
	}

	// Parte privada de nuestra aplicación Web donde el usuario podrá loguearse y
	// registrarse.
	@RequestMapping("/areaprivada")
	public String areaPrivada() {
		return "areaprivada";
	}

	// Login Entrenador.
	@PostMapping("/login")
	public String loginEntrenador(Model model, @RequestParam String user, @RequestParam String password,
			HttpSession sesion) {

		// Comprobamos si existe o no un Entrenador registrado con ese "user" y "password".
		Entrenador entrenador = entrenadorRepository.findByUserAndPassword(user, password);

		// Si existe devuelve la información.
		if (entrenador != null) {
			sesion.setAttribute("user", user);
			sesion.setAttribute("password", password);
			userCompartida = user;
			passwordCompartida = password;

			return "loggincorrecto";
		} else {
			// Si no existe notifica el error al usuario.
			return "errorentrenadornoexiste";
		}
	}

	// Área de gestión del entrenador donde podra gestionar su equipo y consultar su
	// información.
	@RequestMapping("/areagestionentrenador")
	public String areaGestionEntrenador() {
		return "areagestionentrenador";
	}

	// Buscar Jugador.
	@GetMapping("/consultarjugador/nombreJugador")
	public String verJugador(Model model, @RequestParam String nombreJugador) {

		// Comprobamos si existe o no un Jugador registrado con ese "nombreJugador".
		Jugador jugador = jugadorRepository.findByNombreJugador(nombreJugador);

		// Si existe, mostramos la información.
		if (jugador != null) {

			model.addAttribute("jugador", jugador);

			return "consultajugador";
		} else {
			// Si no existe notifica el error al usuario.
			return "errorjugadornoexiste";
		}
	}

	// Buscar Plantilla Equipo.
	@GetMapping("/consultarequipo/nombreEquipo")
	public String verEquipo(Model model, @RequestParam String nombreEquipo) {

		// Comprobamos si existe o no un Equipo registrado con ese "nombreEquipo".
		Equipo existe = equipoRepository.findByNombreEquipo(nombreEquipo);

		// Si existe, mostramos la información.
		if (existe != null) {
			List<Jugador> jugador = jugadorRepository
					.findDistinctJugadoresByEquipoJugadorOrderByValorMercadoDesc(nombreEquipo);

			model.addAttribute("jugador", jugador);

			return "consultaequipo";
		} else {
			// Si no existe notifica el error al usuario.
			return "errorequiponoexiste";
		}
	}

	// Buscar Edad Jugadores.
	@GetMapping("/consultaredadjugadores/edad")
	public String verEdadJugadores(Model model, @RequestParam int edad) {

		// Comprobamos si existe o no un Jugador registrado con ese "edad".
		List<Jugador> existe = jugadorRepository.findByEdad(edad);

		// Si existe, mostramos la información.
		if (existe.isEmpty()) {

			return "errornoexistejugadoredad";
		} else {
			// Si no existe notifica el error al usuario.
			List<Jugador> jugador = jugadorRepository.findDistinctJugadoresByEdadOrderByValorMercadoDesc(edad);

			model.addAttribute("jugador", jugador);

			return "consultaedadjugadores";
		}
	}

	// Buscar Nacionalidad Jugadores.
	@GetMapping("/consultarpaisjugadores/nacionalidadJugador")
	public String verNacionalidadJugadores(Model model, @RequestParam String nacionalidadJugador) {

		// Comprobamos si existe o no un Jugador registrado con ese "nacionalidad".
		List<Jugador> existe = jugadorRepository.findByNacionalidadJugador(nacionalidadJugador);

		// Si existe, mostramos la información.
		if (existe.isEmpty()) {

			return "errornoexistejugadornacionalidad";
		} else {
			// Si no existe notifica el error al usuario.
			List<Jugador> jugador = jugadorRepository
					.findDistinctJugadoresByNacionalidadJugadorOrderByValorMercadoDesc(nacionalidadJugador);

			model.addAttribute("jugador", jugador);

			return "consultanacionalidadjugadores";
		}
	}

	// Palmarés.
	@GetMapping("/consultarpalmares/nombreLiga")
	public String verPalmares(Model model, @RequestParam String nombreLiga) {

		// Comprobamos si existe o no un Jugador registrado con ese "nacionalidad".
		Torneo existe = torneoRepository.findByNombreLiga(nombreLiga);

		// Si existe, mostramos la información.
		if (existe != null) {
			List<Equipo> equipo = equipoRepository.findDistinctEquiposByLigaOrderByNumTorneoGanadosDesc(nombreLiga);

			model.addAttribute("equipo", equipo);

			return "consultapalmares";
		} else {
			// Si no existe notifica el error al usuario.
			return "errortorneonoexiste";
		}
	}

	// Buscar Torneo.
	@GetMapping("/consultartorneo/nombreLiga")
	public String verTorneo(Model model, @RequestParam String nombreLiga) {

		// Comprobamos si existe o no un Jugador registrado con ese "nacionalidad".
		Torneo existe = torneoRepository.findByNombreLiga(nombreLiga);

		// Si existe, mostramos la información.
		if (existe != null) {
			List<Equipo> equipo = equipoRepository.findDistinctEquiposByLigaOrderByNombreEquipoAsc(nombreLiga);

			model.addAttribute("equipo", equipo);

			return "consultatorneo";
		} else {
			// Si no existe notifica el error al usuario.
			return "errortorneonoexiste";
		}
	}

	// Registrar Entrenador.
	@PostMapping("/entrenador/nuevo")
	public String registroEntrenador(@RequestParam String nombreEntrenador, @RequestParam String equipoEntrenador,
			@RequestParam String user, @RequestParam String password) {
		// Comprobamos si existe o no un Entrenador registrado prevamente con ese "user" y
		// "password".
		Entrenador existe = entrenadorRepository.findByUserAndPassword(user, password);

		// Si no existe lo crea (registra).
		if (existe == null) {
			Entrenador entrenador = new Entrenador(nombreEntrenador, equipoEntrenador, user, password);
			entrenadorRepository.save(entrenador);
			return "entrenadorregistrado";
		} else {
			// Si existe notifica el error al usuario y no lo registra.
			return "errorregistro";
		}
	}

	// Información Entrenador.
	@GetMapping("/informacionentrenador/user/password")
	public String verEntrenador(Model model, HttpSession sesion) {

		// Cargamos los datos de la sesión del entrenador.
		String user = (String) sesion.getAttribute("user");
		String password = (String) sesion.getAttribute("password");

		model.addAttribute("user", user);
		model.addAttribute("password", user);

		model.addAttribute("userCompartida", userCompartida);
		model.addAttribute("passwordCompartida", passwordCompartida);

		Entrenador entrenador = entrenadorRepository.findByUserAndPassword(user, password);

		model.addAttribute("Entrenador", entrenador);

		return "consultardatosentrenador";
	}

	// Inscribir Equipo.
	@GetMapping("/registrarequipo/user/password")
	public String registrarequipoEntrenador(Model model, HttpSession sesion) {

		// Cargamos los datos de la sesión del Entrenador.
		String user = (String) sesion.getAttribute("user");
		String password = (String) sesion.getAttribute("password");

		model.addAttribute("user", user);
		model.addAttribute("password", user);

		model.addAttribute("userCompartida", userCompartida);
		model.addAttribute("passwordCompartida", passwordCompartida);

		Entrenador entrenador = entrenadorRepository.findByUserAndPassword(user, password);

		model.addAttribute("entrenador", entrenador);

		return "registrarequipo";
	}

	// Registrar Equipo.
	@PostMapping("/equipo/nuevo")
	public String registroEquipo(@RequestParam String nombreEquipo, @RequestParam String liga,
			@RequestParam String nacionalidadEquipo, @RequestParam int numTorneoGanados, HttpSession sesion) {

		// Comprobamos si existe o no un Equipo registrado con ese "nombreEquipo".
		Equipo existe = equipoRepository.findByNombreEquipo(nombreEquipo);

		// Si no existe, continuamos con el registro del equipo.
		if (existe == null) {
			Equipo equipo = new Equipo(nombreEquipo, liga, nacionalidadEquipo, numTorneoGanados);
			equipoRepository.save(equipo);

			return "equiporegistrado";
		} else {
			// Si existe notifica el error al usuario y no lo registra.
			return "errorregistroequipo";
		}
	}

	// Inscribir Jugador.
	@GetMapping("/registrarjugador/user/password")
	public String registrarJugadorEntrenador(Model model, HttpSession sesion) {

		// Cargamos los datos de la sesión del Entrenador.
		String user = (String) sesion.getAttribute("user");
		String password = (String) sesion.getAttribute("password");

		model.addAttribute("user", user);
		model.addAttribute("password", user);

		model.addAttribute("userCompartida", userCompartida);
		model.addAttribute("passwordCompartida", passwordCompartida);

		Entrenador entrenador = entrenadorRepository.findByUserAndPassword(user, password);

		model.addAttribute("entrenador", entrenador);

		return "registrarjugador";
	}

	// Registrar Jugador.
	@PostMapping("/jugador/nuevo")
	public String registroJugador(@RequestParam String nombreJugador, @RequestParam String equipoJugador,
			@RequestParam String posicion, @RequestParam int edad, @RequestParam String nacionalidadJugador,
			@RequestParam int valorMercado, HttpSession sesion) {

		// Comprobamos si existe o no un Jugador registrado con ese "nombreJugador".
		Jugador existe = jugadorRepository.findByNombreJugador(nombreJugador);

		// Si no existe, continuamos con el registro del equipo.
		if (existe == null) {
			Jugador jugador = new Jugador(nombreJugador, equipoJugador, posicion, edad, nacionalidadJugador,
					valorMercado);
			jugadorRepository.save(jugador);

			return "jugadorregistrado";
		} else {
			// Si existe notifica el error al usuario y no lo registra.
			return "errorregistrojugador";
		}
	}

}
