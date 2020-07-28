package top.tinn.CS_Notes.UDP;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @ClassName UDP_receiver
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/24 15:03
 */
public class UDP_receiver {
    /**
     ** 2.接收Receive
     * 创建DatagramSocket, 指定端口号
     * 创建DatagramPacket, 指定数组, 长度
     * 使用DatagramSocket接收DatagramPacket
     * 关闭DatagramSocket
     * 从DatagramPacket中获取数据
     * @throws Exception
     */
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        socket.receive(packet);

        byte[] ret = packet.getData();
        int len = packet.getLength();
        System.out.println(new String(ret, 0, len));
        socket.close();
    }
}
