package m2dl.pcr.rmi.part1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String args[]) {

        String host = (args.length < 1 ? null : args[0]);
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Hello stub = (Hello) registry.lookup("Hello");
            String response = stub.sayHello();
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.err.println("Client error: " + e.toString());
            e.printStackTrace();
        }

    }

}
