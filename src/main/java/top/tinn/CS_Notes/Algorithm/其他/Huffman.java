package top.tinn.CS_Notes.Algorithm.其他;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {
    private class Node implements Comparable<Node>{
        private char ch;
        private int freq;
        private boolean isLeaf;
        private Node left, right;

        public Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
            isLeaf = true;
        }

        private Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            return this.freq - o.freq;
        }

        public boolean isLeaf(){
            return left == null && right == null;
        }
    }

    public Map<Character, String> encode(Map<Character, Integer> freqForChar){
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (char c : freqForChar.keySet()){
            priorityQueue.add(new Node(c, freqForChar.get(c)));
        }
        //build huffman tree
        while (priorityQueue.size() > 1){
            Node node1 = priorityQueue.poll();
            Node node2 = priorityQueue.poll();
            priorityQueue.add(new Node(node1.freq + node2.freq, node1, node2));
        }
        //from tree to encode
        return encode(priorityQueue.poll());
    }

    private Map<Character, String> encode(Node root) {
        Map<Character, String> encodingForChar = new HashMap<>();
        encode(root, "", encodingForChar);
        return encodingForChar;
    }

    private void encode(Node node, String encoding, Map<Character, String> encodingForChar) {
        if (node.isLeaf){
            encodingForChar.put(node.ch, encoding);
            return;
        }
        encode(node.left, encoding + "0", encodingForChar);
        encode(node.right, encoding + "1", encodingForChar);
    }

    public static void main(String[] args) {
        Map<Character, Integer> freqForChar = new HashMap<>();
        Huffman huffman = new Huffman();
        freqForChar.put('a', 12);
        freqForChar.put('b', 40);
        freqForChar.put('c', 15);
        freqForChar.put('d', 5);
        freqForChar.put('e', 25);
        Map<Character, String> encoding = huffman.encode(freqForChar);
        System.out.println(encoding);
    }
}
