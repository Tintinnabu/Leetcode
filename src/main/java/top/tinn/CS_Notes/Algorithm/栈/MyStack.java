package top.tinn.CS_Notes.Algorithm.栈;

public interface MyStack<T> extends Iterable<T> {
    MyStack<T> push(T t);
    T pop() throws Exception;
    boolean isEmpty();
    int size();
}
