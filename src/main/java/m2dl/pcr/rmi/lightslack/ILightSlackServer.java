package m2dl.pcr.rmi.lightslack;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ILightSlackServer extends Remote {

    void sendMessage(String msg) throws RemoteException;
    List<String> getAllMessages() throws RemoteException;
    void registerClient(ILightSlackClient client) throws RemoteException;
    void notifyClients() throws RemoteException;

}
