/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Client.ClientConstant.*;

/**
 *
 * @author LEVU
 */
public class MessageRecever implements Runnable {
    ObjectInputStream input;
    boolean keepListening = true;
    ClientListListener clientListListener;
    ClientWindowListener clientWindowListener;
    ClientManager clientManager;
    Socket clientSocket;
    ExecutorService clientExecutor;

    MessageRecever(Socket getClientSocket, ClientListListener getClientListListener,
            ClientWindowListener getClientWindowListener, ClientManager getClientManager) {
        clientExecutor = Executors.newCachedThreadPool();
        clientManager = getClientManager;
        clientSocket = getClientSocket;
        try {
            input = new ObjectInputStream(getClientSocket.getInputStream());
        } catch (IOException ex) {
        }
        clientListListener = getClientListListener;
        clientWindowListener = getClientWindowListener;
    }

    public void run() {
        String message, name = "";
        while (keepListening) {
            try {
                message = (String) input.readObject();
                System.out.println("user is receiving " + message);
                StringTokenizer tokens = new StringTokenizer(message);

                String header = tokens.nextToken();
                if (tokens.hasMoreTokens()) {
                    name = tokens.nextToken();
                }
                if (header.equalsIgnoreCase("login")) {
                    clientListListener.addToList(name);
                } else if (header.equalsIgnoreCase(DISCONNECT_STRING)) {
                    clientListListener.removeFromList(name);
                } else if (header.equalsIgnoreCase("server")) {
                    clientWindowListener.closeWindow(message);
                } else {
                    clientWindowListener.openWindow(message);
                }
            } catch (IOException ex) {
                clientListListener.removeFromList(name);
            } catch (ClassNotFoundException ex) {

            }
        }
    }

    void stopListening() {
        keepListening = false;
    }
}
