package top.tinn.NowCoder.Huawei_0923.Problem_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/23 21:32
 */
public class Main {
    static Node root = new Node("/");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            String[] sen = str.split(" ");
            if (sen.length == 1){
                ls(root, "/");
            }else if (sen.length == 2){
                String opt = sen[0];
                String path = sen[1];
                if (opt.equals("mkdir")){
                    mkdir(path.split("/"), 1, root);
                }else if (opt.equals("rm")){
                    rm(path.split("/"), 1, root);
                }
            }else if (sen.length == 3){
                String src = sen[1];
                String dst = sen[2];
                mv(root, src, dst);
            }
        }
    }

    private static void mv(Node root, String src, String dst) {
        Node father = getFrom(root, src.split(" "), 0);
        getFrom(root, dst.split(" "), 0).children.addAll(father.children);
        father.children.clear();
    }

    private static Node getFrom(Node node, String[] s, int i) {
        if (i == s.length - 1){
            return node;
        }else {
            for (Node child : node.children){
                if (child.path.equals(s[i])){
                    getFrom(child, s, i + 1);
                }
            }
        }
        return null;
    }

    private static void ls(Node node, String pre) {
        System.out.println(pre);
        for (Node child : node.children){
            ls(child, pre + child.path);
        }
    }

    private static void rm(String[] s, int i, Node node) {
        if (i == s.length - 1){
            node.children.clear();
        }else {
            for (Node child : node.children){
                if (child.path.equals(s[i])){
                    rm(s, i + 1, child);
                }
            }
        }
    }

    private static void mkdir(String[] s, int i, Node node) {
        if (i >= s.length){
            return;
        }
        String curPath = s[i];
        for (Node child : node.children){
            if (child.path.equals(curPath)){
                mkdir(s, i + 1, child);
            }
        }
        Node nowNode = new Node(curPath);
        node.children.add(nowNode);
        mkdir(s, i + 1, nowNode);
    }


    static class Node{
        String path;
        List<Node> children;
        public Node(String path) {
            this.path = path;
            children = new ArrayList<>();
        }
    }
}
