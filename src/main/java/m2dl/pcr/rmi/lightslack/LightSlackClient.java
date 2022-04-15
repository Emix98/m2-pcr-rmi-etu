package m2dl.pcr.rmi.lightslack;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LightSlackClient extends UnicastRemoteObject implements ILightSlackClient {

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
