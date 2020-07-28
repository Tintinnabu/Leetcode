package top.tinn.CS_Notes.UDP;

import java.io.IOException;
import java.net.*;

/**
 * @ClassName UDP_sender
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/24 15:07
 */
public class UDP_sender {
/**
      * * 1.发送Send
      * 创建DatagramSocket, 随机端口号
      * 创建DatagramPacket, 指定数据, 长度, 地址, 端口
      * 使用DatagramSocket发送DatagramPacket
      * 关闭DatagramSocket
      * @throws SocketException
      * @throws UnknownHostException
      */
    public static void main(String[] args) throws IOException {
        String message = "hello from " + UDP_sender.class.getSimpleName();
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), InetAddress.getLocalHost(), 6666);
        socket.send(packet);
        socket.close();
    }
}
