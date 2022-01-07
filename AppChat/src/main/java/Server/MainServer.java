package Server;


import Server.ServerManager;
import Server.ServerMonitor;
/**
 *
 * @author LEVU
 */
public class MainServer
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ServerManager serverManager=new ServerManager();
        ServerMonitor monitor=new ServerMonitor(serverManager);

        monitor.setVisible(true);
    }

}
