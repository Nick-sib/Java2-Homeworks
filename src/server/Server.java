package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Server {
    private List<ClientHandler> clients;
    private AuthService authService;

    public AuthService getAuthService() {
        return authService;
    }

    public Server() {
        clients = new Vector<>();
        authService = new SimpleAuthService();

        ServerSocket server = null;
        Socket socket;

        final int PORT = 8189;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                System.out.println("socket.getRemoteSocketAddress(): "+socket.getRemoteSocketAddress());
                System.out.println("socket.getLocalSocketAddress() "+socket.getLocalSocketAddress());
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void broadcastMsg(String msg, String from){
        for (ClientHandler client : clients) {
            client.sendMsg(String.format("/from %s : %s", from, msg));
        }
    }

    boolean privateMSG(String msg, String nick, String from) {
        boolean res = false;
        for (ClientHandler client : clients) {
            if (client.isYou(nick) || client.isYou(from)) {
                client.sendMsg(String.format("/from %s : %s", from, msg));
                res = true;
            }
        }
        return res;
    }

    public void subscribe(ClientHandler clientHandler){
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler){
        clients.remove(clientHandler);
    }

    boolean checkNick(String nick) {
        //делаем ники только уникальными
        for (ClientHandler client : clients)
            if (client.getNick().equals(nick))
                return false;
        return true;
    }

}
