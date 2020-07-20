package top.tinn.CS_Notes.Algorithm.队列;

public interface MyQueue<T> extends Iterable<T> {
    int size();

    boolean isEmpty();

    MyQueue<T> add(T t);

    T remove() throws Exception;
}
