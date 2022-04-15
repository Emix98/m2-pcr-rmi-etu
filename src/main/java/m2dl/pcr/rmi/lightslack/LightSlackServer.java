package m2dl.pcr.rmi.lightslack;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

public class LightSlackServer implements ILightSlackServer {

    List<String> messages = new LinkedList<>();
    String lastMessage;
    List<ILightSlackClient> clients = new LinkedList<>();

    @Override
    public void sendMessage(String msg) {
        this.lastMessage = msg;
        this.messages.add(msg);
        this.notifyClients();
    }

    @Override
    public List<String> getAllMessages() {
        return messages;
    }

    @Override
    public void registerClient(ILightSlackClient client) {
        clients.add(client);
    }

    @Override
    public void notifyClients() {
        for (ILightSlackClient client : clients) {
            try {
                client.receiveMessage(this.lastMessage);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        lastMessage = null;
    }

    public static void main(String args[]) {
        try {
            LightSlackServer obj = new LightSlackServer();
            LocateRegistry.createRegistry(1099);
            ILightSlackServer stub = (ILightSlackServer) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("LightSlackServer", stub);
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
