package TCPTest;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @author wuyuan
 * @create 2020-04-26 22:41
 *
 *  UDPd协议的网络编程
 *  * @author shkstart
 *  * @create 2019 下午 4:34
 */
public class UDPTest {
    //发送端
    @Test
    public void senger(){
        DatagramSocket datagramSocket = null;
        DatagramPacket datagramPacket = null;
        try {
            datagramSocket = new DatagramSocket();

            String str = "我是UDP方式发送的信息";

            byte[] bytes = str.getBytes();
            InetAddress inetAddress =InetAddress.getByName("127.0.0.1");
            datagramPacket = new DatagramPacket(bytes, 0, bytes.length, inetAddress,9090);
            datagramSocket.send(datagramPacket);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null)
            datagramSocket.close();
        }

    }

//    接收端
    @Test
    public void receiver(){
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket(9090);

            byte[] bytes = new byte[100];
            DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);

            serverSocket.receive(packet);

            String data = new String (packet.getData(),0,packet.getLength());
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null)
            serverSocket.close();
        }
    }
}
