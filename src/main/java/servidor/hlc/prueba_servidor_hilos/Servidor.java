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

            InputStream entrada = conexionCliente.getInputStream();

            DataInputStream flujoEntrada = new DataInputStream(entrada);

            System.out.println("Mensaje del CLIENTE " + i + ":\n\t" + flujoEntrada.readUTF() + "\n");

            OutputStream salida = conexionCliente.getOutputStream();

            DataOutputStream flujoSalida = new DataOutputStream(salida);

            flujoSalida.writeUTF("Saludos al cliente " + i + " del servidor");

            entrada.close();
            flujoEntrada.close();
            salida.close();
            flujoSalida.close();
            conexionCliente.close();

        }

    }

}
