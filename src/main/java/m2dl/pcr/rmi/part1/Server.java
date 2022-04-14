package m2dl.pcr.rmi.part1;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {

    public String sayHello() throws RemoteException {
        return "Hello world / This is me / Life should be / Hum hum yeah / Fun for everyone";
    }

    public static void main(String args[]) {

        try {
            Server obj = new Server();
            LocateRegistry.createRegistry(1099);
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }

    }

}
