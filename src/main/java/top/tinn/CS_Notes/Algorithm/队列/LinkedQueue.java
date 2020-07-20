package top.tinn.CS_Notes.Algorithm.队列;

import top.tinn.CS_Notes.Algorithm.栈.LinkedStack;

import java.util.Iterator;

public class LinkedQueue<T> implements MyQueue<T> {
    private Node head;
    private Node tail;
    int N = 0;

    private class Node{
        Node next;
        T t;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public MyQueue<T> add(T t) {
        Node node = new Node();
        node.t = t;
        node.next = null;
        if (isEmpty()){
            head = node;
        }else {
            tail.next = node;
        }
        tail = node;
        N++;
        return this;
    }

    @Override
    public T remove() throws Exception {
        if (isEmpty()){
            throw new Exception();
        }
        Node node = head;
        head = head.next;
        N--;
        if (isEmpty()){
            tail = null;
        }
        return node.t;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node cur = head;
            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public T next() {
                T t = cur.t;
                cur = cur.next;
                return t;
            }
        };
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 5; i++){
            queue.add(i);
        }
        for (Integer i : queue){
            System.out.println(i);
        }
    }
}
