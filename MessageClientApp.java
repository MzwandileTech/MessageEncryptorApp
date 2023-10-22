package messageclientapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageClientApp {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        try {
            Socket clientSocket = new Socket("127.0.0.1", 2081);

            System.out.println("CLIENT SIDE");
            System.out.println("----------------------");
            System.out.println();

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.print("Enter your message: ");
            String msg = reader.nextLine();

            out.println(msg);

            String encryptedMsg = in.readLine();
            System.out.println();

            System.out.println("Your new encrypted message: ");
            System.out.println(encryptedMsg);

        } catch (IOException ex) {
            Logger.getLogger(MessageClientApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
