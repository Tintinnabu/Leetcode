package top.tinn.CS_Notes.Algorithm.栈;



import java.util.Iterator;

public class LinkedStack<T> implements MyStack<T> {
    private Node head = null;
    private int N = 0;

    private class Node{
        Node next;
        T t;
    }


    @Override
    public MyStack<T> push(T t) {
        Node node = new Node();
        node.t = t;
        node.next = head;
        head = node;
        N++;
        return this;
    }

    @Override
    public T pop() throws Exception {
        if (isEmpty()){
            throw  new Exception("stack is empty");
        }
        T t = head.t;
        N--;
        head = head.next;
        return t;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node cur = head;
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
        LinkedStack<Integer> stack = new LinkedStack<>();
        for (int i = 0; i < 5; i++){
            stack.push(i);
        }
        for (Integer i : stack){
            System.out.println(i);
        }
    }
}
