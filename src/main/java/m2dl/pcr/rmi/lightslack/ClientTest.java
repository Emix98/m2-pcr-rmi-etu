package m2dl.pcr.rmi.lightslack;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class ClientTest {

    public static void main(String[] args) {
        String host = (args.length < 1 ? null : args[0]);
        Scanner lyoko = new Scanner(System.in);
        System.out.print("Veuillez saisir votre nom : ");

        try {
            ILightSlackClient client = new LightSlackClient(lyoko.nextLine());
            Registry registry = LocateRegistry.getRegistry(host);
            ILightSlackServer stub = (ILightSlackServer) registry.lookup("LightSlackServer");
            client.registerServer(stub);
            String messageSent;

            List<String> serverMessages = stub.getAllMessages();
            for (String msg : serverMessages) {
                System.out.println(msg);
            }

            while (true) {
                System.out.print("Votre message : ");
                messageSent = client.getInstanceName() + " : " + lyoko.nextLine();
                stub.sendMessage(messageSent);
            }
        } catch (Exception e) {
            System.err.println("Client error: " + e.toString());
            e.printStackTrace();
        }
    }

}
