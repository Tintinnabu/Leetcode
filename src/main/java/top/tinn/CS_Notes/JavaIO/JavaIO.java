package top.tinn.CS_Notes.JavaIO;

import sun.security.provider.NativePRNG;

import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class JavaIO {
    //递归地列出一个目录下所有文件
    public static void listAllFiles(File dir){
        if (dir == null || !dir.exists()){
            return;
        }
        if (dir.isFile()){
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles()){
            listAllFiles(file);
        }
    }

    //文件复制
    public static void copyFile(String src, String dist) throws IOException{
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);
        byte[] buffer = new byte[20 * 1024];
        int cnt;
        while ((cnt = in.read(buffer, 0, buffer.length)) != -1){
            out.write(buffer, 0, cnt);
        }
        in.close();
        out.close();
    }

    //String 的编码方式
    public static void code() throws UnsupportedEncodingException {
        String str1 = "中文";
        byte[] bytes = str1.getBytes("UTF-8");
        System.out.println(bytes.length);
        String str2 = new String(bytes, "UTF-8");
        System.out.println(str2);
    }

    //实现逐行输出文本文件的内容
    public static void readFileContent(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        bufferedReader.close();
    }

    //序列化测试
    public static void serialize() throws IOException, ClassNotFoundException {
        A a1 = new A(123, "abc");
        System.out.println(a1);
        //不能序列化静态变量
        a1.z = 20;
        String objFile = "temp/CS_Notes";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objFile));
        objectOutputStream.writeObject(a1);

        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objFile));
        A a2 = (A) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(a2);
    }

    public static void readByURL() throws IOException {
        URL url = new URL("https://www.baidu.com");
        InputStream is = url.openStream();
        InputStreamReader isr = new InputStreamReader(is, "utf-8");
        BufferedReader br = new BufferedReader(isr);
        File file = new File("temp/baidu.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        String line;
        while ((line = br.readLine()) != null){
            bw.write(line);
            System.out.println(line);
        }
        br.close();
        bw.close();
    }

    //NIO fastCopy
    public static void fastCopy(String src, String dist) throws IOException {
        FileInputStream fin = new FileInputStream(src);
        FileChannel fcin = fin.getChannel();
        FileOutputStream fout = new FileOutputStream(dist);
        FileChannel fcout = fout.getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        while (true){
            int r = fcin.read(buffer);
            if (r == -1){
                break;
            }
            buffer.flip();
            fcout.write(buffer);
            buffer.clear();
        }
    }

    //非阻塞IO
    public static void NonBlockingIO() throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            int num = selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    // ...
                } else if (key.isReadable()) {
                    // ...
                }
                keyIterator.remove();
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //File file = new File("C:\\Users\\213\\OneDrive - sjtu.edu.cn\\coding\\pdf");
        //listAllFiles(file);
        //code();
        //readFileContent("C:\\Users\\213\\Desktop\\eshop\\src\\bean\\Account.java");
        //serialize();
        //readByURL();
        fastCopy("temp/baidu.html", "temp/baidu2.html");
    }


}
class A implements Serializable{
    private int x;
    private String y;
    public static int z;

    public A(int x, String y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "A{" +
                "x=" + x +
                ", y='" + y + '\'' +
                ", z=" + z +
                '}';
    }
}