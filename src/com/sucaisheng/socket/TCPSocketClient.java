package com.sucaisheng.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * socket客户端
 */
public class TCPSocketClient {
    public static void main(String[] args) {
        //创建一个客户端socket类,传入需要连接的服务器地址和端口号
        Socket socket;
        try {
            socket = new Socket("127.0.0.1", 8888);
            //使用socket类获取输出字节流
            OutputStream out = socket.getOutputStream();
            //使用write方法发送数据
            out.write("你好服务器！".getBytes());
            //使用socket获取字节读取流
            InputStream in = socket.getInputStream();
            //使用字节输入流读取服务器发送的数据
            byte[] bytes = new byte[1024];
            int len = in.read(bytes);
            System.out.println(new String(bytes,0,len));
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
