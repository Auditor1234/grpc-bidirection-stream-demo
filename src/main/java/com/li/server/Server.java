package com.li.server;

import java.io.IOException;

public class Server {
    private BidirectionServer fServer;

    public Server(){
        this.fServer = new BidirectionServer();
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    public void start(){
        try {
            this.fServer.start();
            this.fServer.blockUntilShutdown();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
