package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by asus on 2017/7/26.
 */
public class MyServer {
    ServerSocket server = null;

    public MyServer() {
        this.startServer();
    }

    void startServer() {
        int i = 0;
        try {
            server = new ServerSocket(8888, 3);
            System.out.println("==========start===========");
            while (true) {
                Socket socket = server.accept();
                i++;
                System.out.println("第" + i + "个用户连接成功！");
                new Thread(new ServerThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
