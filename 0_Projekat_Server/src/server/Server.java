/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;
import configuration.Configuration;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import threads.ClientHandler;

/**
 *
 * @author s
 */
public class Server extends Thread{
 private boolean flag = true;
private ServerSocket serverSocket;
private List<ClientHandler> threads = new ArrayList<>();

@Override
public void run() {
    try {
        serverSocket = new ServerSocket(Integer.parseInt(Configuration.getInstance().getProperty("port")));
        while (flag) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            ClientHandler clientHandler = new ClientHandler(socket);
            threads.add(clientHandler);
            clientHandler.start();
            
        }
    } catch (IOException ex) {
        System.out.println("Socket has been closed");
    }
}

public void stopServer() {
    try {
        flag = false;
        serverSocket.close();

        for (ClientHandler clientHandler : threads) {
            clientHandler.stopThread();
        }
    } catch (IOException ex) {
        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}