package com.sucaisheng.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket服务端代码
 */
public class TCPServer {
    public static void main(String[] args) {
        //获取ServerSocket对象，指定端口
        ServerSocket serverSocket;
            try {
                serverSocket = new ServerSocket(8888);
                //使用accept方法获取到客户端发送来的socket
                Socket socket = serverSocket.accept();
                //使用socket获取字节输入流，读取客户端发送的数据
                InputStream in = socket.getInputStream();
                //使用read方法读取客户端发送的数据
                byte[] bytes = new byte[1024];
                int len = in.read(bytes);
                System.out.println(new String(bytes,0,len));
                //使用socket获取字节输出流，向客户端发送数据
                OutputStream out = socket.getOutputStream();
                out.write("收到，谢谢！".getBytes());
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

