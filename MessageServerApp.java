package messageserverapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageServerApp {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(2081);

            Socket clientSocket = serverSocket.accept();

            System.out.println("SERVER SIDE");
            System.out.println("----------------------");
            System.out.println();

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String uncryptedMsg = in.readLine().toLowerCase();

            System.out.println("The unecrypted message from the client side: ");

            System.out.println(uncryptedMsg);
            
              System.out.println();

              String encryptedMsg = msgEncryptorTechnique(uncryptedMsg);
            
              out.println(encryptedMsg);
            
            System.out.println("The new ecrypted message: ");

            System.out.println(encryptedMsg);
            

        } catch (IOException ex) {
            Logger.getLogger(MessageServerApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static String msgEncryptorTechnique(String uncryptedMsg)
    {
          char[] values = uncryptedMsg.toCharArray();

        for (int i = 0; i < values.length; i++) {
            char currentChar = values[i];
            if (currentChar == 'a') {
                values[i] = '1';
            } else if (currentChar == 'e') {
                values[i] = '2';
            } else if (currentChar == 'i') {
                values[i] = '3';
            } else if (currentChar == 'o') {
                values[i] = '4';
            } else if (currentChar == 'u') {
                values[i] = '5';
            }
        }

        // Convert the modified char array back to a string
        return new String(values);
    }
}


