/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.hlc.prueba_servidor_hilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dam
 */
public class HiloServidor extends Thread{
    
    private int numCli;
    private Socket conexionCliente;
    private DataInputStream flujoEntrada;
    private DataOutputStream flujoSalida;

    public HiloServidor(Socket conexionCliente, int i) throws IOException {
        this.conexionCliente = conexionCliente;
        this.flujoEntrada = new DataInputStream(conexionCliente.getInputStream());
        this.flujoSalida = new DataOutputStream(conexionCliente.getOutputStream());
        this.numCli = i;
    }
    
    @Override
    public void run(){
        try {
            System.out.println("Mensaje del CLIENTE " + numCli + ":\n\t" + flujoEntrada.readUTF() + "\n");
            
            flujoSalida.writeUTF("Saludos al cliente " + numCli + " del servidor");
            
            flujoEntrada.close();
            flujoSalida.close();
            conexionCliente.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
