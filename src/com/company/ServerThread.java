package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by asus on 2017/7/26.
 */
public class ServerThread implements Runnable {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    // 任务是为一个用户提供服务
    @Override
    public void run() {
        try {
            try {
                // 读取客户端传过来信息的DataInputStream
                DataInputStream in = new DataInputStream(
                        socket.getInputStream());
                // 向客户端发送信息的DataOutputStream
                DataOutputStream out = new DataOutputStream(
                        socket.getOutputStream());
                while (true) {
                    // 读取来自客户端的信息
                    String accpet = in.readUTF();
                    System.out.println(accpet);
                    out.writeUTF("服务器：" + accpet);
                }
            } finally {// 建立连接失败的话不会执行socket.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
