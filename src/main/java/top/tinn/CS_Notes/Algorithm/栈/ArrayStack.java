package top.tinn.CS_Notes.Algorithm.栈;

import java.util.Iterator;

public class ArrayStack<T> implements MyStack<T> {
    private T[] a = (T[]) new Object[1];
    private int N = 0;
    @Override
    public MyStack<T> push(T t) {
        check();
        a[N++] = t;
        return this;
    }

    private void check() {
        if (N >= a.length){
            resize(2 * a.length);
        }else if (N > 0 && N <= a.length / 4){
            resize(a.length / 2);
        }
    }

    private void resize(int size) {
        T[] temp = (T[]) new Object[size];
        System.arraycopy(a, 0, temp, 0, N);
        a = temp;
    }

    @Override
    public T pop() throws Exception {
        if (isEmpty()){
            throw new Exception("stack is empty.");
        }
        T t = a[--N];
        check();
        a[N] = null;
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
            private int i = N;
            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public T next() {
                return a[--i];
            }
        };
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++){
            stack.push(i);
        }
        for (Integer i : stack){
            System.out.println(i);
        }
    }
}
