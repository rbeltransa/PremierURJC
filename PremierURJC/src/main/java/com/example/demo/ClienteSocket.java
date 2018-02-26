package com.example.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteSocket {

  private String host;
  private int puerto;
  
  public ClienteSocket() {
    this.host = "127.0.0.1";
    this.puerto = 5555;
   }
   
  public void enviarInfoJugador(String nombreJugador, String equipoJugador, String posicion, int edad, 
                                String nacionalidadJugador, int valorMercado) {
    try{
      Socket socket = new Socket(this.host, this.puerto);
      PrintWriter escribirInfo = neew PrintWriter(socket.getOutputStream(), true);
      
      escribirInfo.println("Nombre Jugador: "+nombreJugador+".");
      escribirInfo.println("Equipo Jugador: "+equipoJugador+".");
      escribirInfo.println("Posicion Jugador: "+posicion+".");
      escribirInfo.println("Edad Jugador: "+edad+".");
      escribirInfo.pritnln("Nacionalidad Jugador: "+nacionalidadJugador+"·");
      escribirInfo.println("Valor de Mercado Jugador: "+valorMercado+".");
      
      escribirInfo.close();
      socket.close();
      
      }catch (IOException e) {
        e.printStackTrace();
      }
  }
  
  public void recibirInfoJugador(String nombreJugador, String equipoJugador) {
    try{
      Socket socket = new Socket(this.host, 4444);
      
      DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
      DataInputStream in = new DataOutputStream(new BufferedInputStream(socket.getInputStream()));
      
      byte[] bytes = new byte[1024];
      
      in.read(bytes);
      
      FileOutputStream fos = new FileOutputStream("fichas/"+equipoJugador+".txt");
      fos.write(bytes);
      
      fos.close(),
      out.close();
      in.close();
      socket.close();
    }catch (Exception e) {
      e.printStackTrace();
    }
  }
}
