/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author s
 */
public class Receiver {
        private Socket socket;

    public Receiver(Socket socket) {
        this.socket = socket;
    }
    public Object receive(){
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                try {
                    return ois.readObject();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException("Received object of unknown class.", ex);
                }
            } catch (IOException ex) {
                    throw new RuntimeException("Error receiving object from socket.", ex);
                    
            }
            
    }
}
