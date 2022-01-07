package Client;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Client.ClientManager;
import Client.LoginFrame;
/**
 *
 * @author LEVU
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ClientManager clientManager=new ClientManager();
        LoginFrame loginFrame=new LoginFrame(clientManager);
        loginFrame.setVisible(true);
        // TODO code application logic here
    }

}
