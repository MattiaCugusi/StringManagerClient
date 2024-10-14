package it.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
         System.out.println("Il client e' partito");
        Socket mySocket = new Socket("localhost", 5670);
        System.out.println("il client si e' collegato");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
        
        Scanner sc = new Scanner(System.in);
        String stringaRicevuta;

       String scelta;

        do{
            System.out.println("1) Trasformare stringa in maiuscolo");
            System.out.println("2) Trasformare stringa in minuscolo");
            System.out.println("3) Ribaltare i caratteri della stringa");
            System.out.println("4) Contare il numero di caratteri");
            System.out.println("5) Esci");
            System.out.println("---------------------------------");
            System.out.println("inserire il numero dell'operazione che si vuol compiere");

            scelta = sc.nextLine();
            System.out.println("inserire riga :");
            String input = sc.nextLine();
            out.writeBytes(scelta + "\n");
            out.writeBytes(input + "\n");
            stringaRicevuta = in.readLine();
            System.out.println("Stringa ricevuta: " + stringaRicevuta);

        }while(!scelta.equals("5"));

        mySocket.close();
    }
}