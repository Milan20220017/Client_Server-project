/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;


import java.io.IOException;
import java.net.Socket;
import Communication.*;


/**
 *
 * @author s
 */
public class ClientController {

    private Socket socket;
    private Sender sender;
    private Receiver receiver;

  

    public ClientController() {
        try {
            socket = new Socket("localhost", 9000);
            sender = new Sender(socket);
            receiver = new Receiver(socket);
            System.out.println("Client is connecting to the server");
        } catch (IOException ex) {
            System.out.println("System is not connected");
        }
    }

    public Object send(Operation operation, Object object) throws Exception {
         if (sender == null || receiver == null) {
             System.out.println("Not connected to the server");
                return null;
    }
        sender.send(new Request(operation, object));

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }

        return response.getResult();
    }
    
}
