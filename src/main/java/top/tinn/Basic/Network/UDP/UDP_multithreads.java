package top.tinn.Basic.Network.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @ClassName UDP_multithreads
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/24 15:14
 */
public class UDP_multithreads {
    public static void main(String[] args) {
        new receiver().start();
        new sender().start();
    }
}

class sender extends Thread{

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            DatagramSocket socket = new DatagramSocket();
            while (true){
                String line = scanner.nextLine();
                System.out.println("send: " + line);
                DatagramPacket packet = new DatagramPacket(line.getBytes(), line.length(), InetAddress.getLocalHost(), 6666);
                socket.send(packet);
                if ("quit".equals(line)){
                    break;
                }
            }
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class receiver extends Thread{

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(6666);
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            while (true){
                socket.receive(packet);
                byte[] ret = packet.getData();
                int len = packet.getLength();
                String msg = new String(ret, 0, len);
                if ("quit".equals(msg)){
                    break;
                }
                System.out.println("receive: " + msg);
            }
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
