package com.company;

import javax.swing.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5056);

        while (true) {
            Socket s = null;

            try {
                s = ss.accept();

                System.out.println("A new client is connected : " + s);

                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                System.out.println("Assigning new thread for this client");

                Thread t = new ClientHandler(s, dis, dos);

                t.start();

            }             catch (Exception ex){
                s.close();
                ex.printStackTrace();
                JFrame frame = new JFrame("Server APP");
                JOptionPane.showMessageDialog(frame, "Client Connection Error!");
            }
        }
    }
}


class ClientHandler extends Thread {
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;


    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        String received;
        String toreturn;


        }
    }
}
