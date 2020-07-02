package client;

import umiun.CONSTS;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientClass {

    private static final String CLASSNAME = "server: ";
    static Boolean doWhile = true;

    public static void main(String[] args) {
        try (Socket socket = new Socket(CONSTS.SERVER_HOST, CONSTS.SERVER_PORT)) {
            System.out.println(CONSTS.MSG_CLIENT_START);
            //Scanner in =  new Scanner(socket.getInputStream());
            Scanner sc = new Scanner(System.in);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            PrinterThread printerThread = new PrinterThread(new Scanner(socket.getInputStream()), CLASSNAME);
            printerThread.start();

            while (printerThread.isAlive()) {
                System.out.println(CONSTS.MSG_INVATE);
                String msg = sc.nextLine();
                if (msg.equals(CONSTS.CMD_END)) {
                    out.println(msg);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(CONSTS.MSG_CLIENT_STOPT);

    }
}
