# Premier URJC
## Miembros del equipo
Fernando Sanchez Garcia

Ruben Beltran Sanchez
## Descripción temática de la web:
Esta aplicación consiste en una base de datos donde se pueden hacer diferentes consultas de fútbol sala. De igual manera, se pueden inscribir nuevos equipos y jugadores en una determinada liga si eres el entrenador de un equipo. Para ello se ha dividido la aplicación en tres partes:

 **Parte Publica:** únicamente se pueden realizar consultas a la base de datos. Se pueden filtrar los resultados de las consultas por:
  -	Nombre del jugador: se mostrarán únicamente los datos de ese jugador.
  -	Equipo: se mostrará toda la plantilla de jugadores pertenecientes a ese equipo, ordenados por su valor de mercado.
  -	Edad: se mostrarán todos los jugadores con esa edad, ordenados por su valor de mercado.
  -	Nacionalidad: se mostrarán todos los jugadores con esa Nacionalidad, ordenados por su valor de mercado.
  -	Liga: se mostrarán todos los equipos participantes en una determinada liga, ordenados alfabéticamente.
  - Palmarés: se mostrarán todos los equipos de una determinada liga, ordenados por el número de torneos ganados de cada uno (mayor a menor).

**Parte Privada:** cada usuario podrá inscribir y administrar a un equipo, gestionar su plantilla y jugadores. Cuando se inscriba un jugador, se deberá indicar su nombre, equipo, edad y valor de mercado.
Un usuario no puede gestionar un equipo que no es el suyo, para evitar que esto ocurra, se gestionará esta funcionalidad mediante un usuario y contraseña para cada usuario.

**Servicio Interno:** El servicio interno de esta aplicación va a ser utilizado para generar las fichas de los jugadores cada vez que se registre un jugador. El cliente le solicitará al servicio interno que, a partir de los datos del formulario de registro del jugador, le genere una ficha con los datos del jugador y se lo enviará al cliente. La aplicación será quien se encargue de almacenarlo en la carpeta correspondiente a su equipo, dentro de la carpeta "fichas" de la aplicación. Ambas aplicaciones se comunicarán mediante sockets.
## Entidades Principales:
  - Jugador: características de un jugador (nombre, equipo al que pertenece, edad, nacionalidad y valor de mercado).
  -  Equipo: nombre de un equipo y plantilla de la que dispone para disputar el Torneo.
  - Entrenador: director de un equipo, el cual es el encargado de inscribir a su equipo en una determinada liga y gestionar su plantilla
  - Torneo: campeonato de la liga en el cual se van a inscribir los equipos.
  - Palmarés: ranking de campeones del torneo.
