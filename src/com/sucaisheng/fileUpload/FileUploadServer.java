package com.sucaisheng.fileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * 文件上传demo服务器代码：
 *    1、创建ServerSocket类
 *    2、使用ServerSocket类中的accept()方法接受客户端发送的socket
 *    3、使用socket获取网络文件输入流
 *    4、读取客户端发送的文件，并创建文件输出流将文件写入服务器磁盘中
 *    5、读取完成向客户端回复接收成功消息
 *    6、关闭文件输出流和socket
 *
 */
public class FileUploadServer {
    public static void main(String[] args) {
        try {
            //1、创建ServerSocket类
            ServerSocket server = new ServerSocket(8888);
            //用一个死循环让服务器一直处于监听状态
            while(true){
                //2、使用ServerSocket类中的accept()方法接受客户端发送的socket
                Socket socket = server.accept();
                //开启多线程，提高效率
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            //3、使用socket获取网络文件输入流
                            InputStream in = socket.getInputStream();
                            //4、读取客户端发送的文件，并创建文件输出流将文件写入服务器磁盘中
                            File file = new File("E:\\java_fuxi\\upload");
                            if (!file.exists()){
                                file.mkdirs();
                            }
                            //重新设计文件的名字
                            String fileName = file + "\\" + System.currentTimeMillis() + new Random().nextInt(9999) + ".jpg";
                            FileOutputStream out = new FileOutputStream(fileName);
                            int len;
                            byte[] bytes = new byte[1024];
                            while((len = in.read(bytes)) != -1){
                                out.write(bytes,0,len);
                            }
                            //5、读取完成向客户端回复接收成功消息
                            OutputStream outputStream = socket.getOutputStream();
                            outputStream.write("收到".getBytes());
                            //6、关闭文件输出流和socket
                            socket.close();
                            out.close();
                        } catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
