package sever;

import umiun.CONSTS;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerClass {

    private static final String CLASSNAME = "client: ";


    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(CONSTS.SERVER_PORT)) {
            System.out.println(CONSTS.MSG_SERVER_START);
            Socket clientSocket = serverSocket.accept();
            Scanner in =  new Scanner(clientSocket.getInputStream());
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            System.out.println(CONSTS.MSG_SERVER_CLIENT_CONECTED);
            SenderThread senderThread = new SenderThread(out);
            senderThread.start();


            while (senderThread.isAlive()) {
                String msg = in.nextLine();
                if (msg.equals(CONSTS.CMD_END)) {
                    senderThread.doThread = false;
                    senderThread.interrupt();
                    out.println(msg);

                    System.out.println(CONSTS.MSG_SERVER_CLIENT_DISCNCTD);

                    break;
                }
                System.out.println(CLASSNAME + msg);
            }

            clientSocket.close();
            serverSocket.close();
            System.out.println(CONSTS.MSG_ANY_KEY);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
