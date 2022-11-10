/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.hlc.prueba_servidor_hilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dam
 */
public class Servidor {

    public static void main(String[] args) throws IOException {

        int puerto = 6010;

        ServerSocket servidor = new ServerSocket(puerto);

        for (int i = 1; ; i++) {

            System.out.println("Esperando a algun cliente...");

            Socket conexionCliente = servidor.accept();

            HiloServidor hiloServidor = new HiloServidor(conexionCliente, i);
            
            hiloServidor.start();

        }

    }

}
