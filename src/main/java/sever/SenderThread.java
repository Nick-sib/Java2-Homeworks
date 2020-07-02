package sever;

import umiun.CONSTS;

import java.io.PrintWriter;
import java.util.Scanner;

public class SenderThread extends Thread {
    boolean doThread = true;
    PrintWriter out;

    SenderThread(PrintWriter out){
        this.out = out;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (doThread) {
            System.out.println(CONSTS.MSG_INVATE);
            String msg = sc.nextLine();
            out.println(msg);
            if (msg.equals(CONSTS.CMD_END)) {
                break;
            }
        }
        System.out.println(CONSTS.MSG_SERVER_STOPT);
    }
}
