package com.sucaisheng.fileUpload;

import java.io.*;
import java.net.Socket;

/**
 * 文件上demo客户端：
 *    1、创建文件输入流，读取需要上传的文件
 *    2、获取socket对象，调用方法获取到网络输出流
 *    3、使用获取到的网络输出流向服务器发送数据
 *    4、发送结束调用方法 void shutdownOutput()，向服务器发送文件结束标记
 *    5、使用socket获取网络输入流，读取服务器返回的数据
 *    6、关闭socket、File流
 */
public class FileUploadClient {
    public static void main(String[] args) {
        //1、创建文件输入流，读取需要上传的文件
        File file = new File("E:\\java_fuxi\\image\\1.jpg");
        try {
            // 2、获取socket对象，调用方法获取到网络输出流
            Socket socket = new Socket("127.0.0.1", 8888);
            OutputStream out = socket.getOutputStream();
            FileInputStream fis = new FileInputStream(file);
            //读取本地硬盘中的文件
            int len;
            byte[] bytes = new byte[1024];
            while((len = fis.read(bytes)) != -1){
                out.write(bytes,0,len);
            }
            //4、发送结束调用方法 void shutdownOutput()，向服务器发送文件结束标记
            socket.shutdownOutput();
            //5、使用socket获取网络输入流，读取服务器返回的数据
            InputStream in = socket.getInputStream();
            while((len = in.read(bytes)) != -1){
                System.out.println(new String(bytes,0,len));
            }
            //6、关闭socket、File流
            fis.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
