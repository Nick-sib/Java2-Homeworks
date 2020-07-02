package client;

import umiun.CONSTS;

import java.util.Scanner;

public class PrinterThread extends Thread {

    Scanner in;
    String CLASSNAME;

    public PrinterThread(Scanner in, String classname) {
        this.in = in;
        CLASSNAME = classname;
    }

    @Override
    public void run() {
        while (true) {
            String msg = in.nextLine();
            if (msg.equals(CONSTS.CMD_END))
                break;

            System.out.println(CLASSNAME + msg);
        }
        System.out.println(CONSTS.MSG_ANY_KEY);
    }
}
