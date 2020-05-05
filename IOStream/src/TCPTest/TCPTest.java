package TCPTest;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wuyuan
 * @create 2020-04-26 20:25
 *
 *  * 实现TCP的网络编程
 *  * 例子1：客户端发送信息给服务端，服务端将数据显示在控制台上
 */
public class TCPTest {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 8888);

            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            os.write("你好，我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            serverSocket = new ServerSocket(8888);

            //2.调用accept()表示接收来自于客户端的socket
            socket = serverSocket.accept();

            //3.获取输入流
            is = socket.getInputStream();

            baos = new ByteArrayOutputStream();

            byte[] bytes = new byte[10];
            int len;
            while ((len = is.read(bytes)) != -1){
                baos.write(bytes,0,len);
            }
            String str = baos.toString();
             String adress = socket.getInetAddress().getHostAddress();
            System.out.println(str);
            System.out.println("来自IP：" + adress + "的信息");
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
