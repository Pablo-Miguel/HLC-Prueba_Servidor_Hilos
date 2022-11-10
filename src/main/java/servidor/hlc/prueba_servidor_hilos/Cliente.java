/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.hlc.prueba_servidor_hilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Dam
 */
public class Cliente {

    public static void main(String[] args) throws IOException {

        String host = "172.20.33.120";
        int puerto = 6010;

        System.out.println("Cliente llamando al servidor...");

        Socket cliente = new Socket(host, puerto);

        DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

        flujoSalida.writeUTF("Saludos al servidor desde el cliente");

        DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

        System.out.println("Mensaje del SERVIDOR: \n\t" + flujoEntrada.readUTF());

        flujoEntrada.close();
        flujoSalida.close();
        cliente.close();

    }
}
