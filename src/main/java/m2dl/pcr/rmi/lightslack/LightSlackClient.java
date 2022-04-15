package m2dl.pcr.rmi.lightslack;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Scanner;

public class LightSlackClient extends UnicastRemoteObject implements ILightStackClient {

    private String instanceName;

    public LightSlackClient(String name) throws RemoteException {
        instanceName = name;
    }

    @Override
    public void receiveMessage(String msg) {
        System.out.println(msg);
    }

    @Override
    public void registerServer(ILightSlackServer server) throws RemoteException {
        server.registerClient(this);
    }

    @Override
    public String getInstanceName() throws RemoteException {
        return instanceName;
    }
}
