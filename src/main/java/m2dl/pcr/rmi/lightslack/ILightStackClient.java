package m2dl.pcr.rmi.lightslack;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILightStackClient extends Remote {

    void receiveMessage(String msg) throws RemoteException;
    void registerServer(ILightSlackServer server) throws RemoteException;
    String getInstanceName() throws RemoteException;

}
