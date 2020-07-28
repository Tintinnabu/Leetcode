package top.tinn.CS_Notes.Algorithm_4th.Chapter3;

/**
 * @ClassName SequentialSearchST
 * @Description 无序链表
 * @Author Tinn
 * @Date 2020/4/23 21:30
 */
public class SequentialSearchST<Key, Value> {
    private class Node{
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    private Node first;

    public Value get(Key key){
        for (Node x = first; x != null; x = x.next){
            if (key.equals(x.key))
                return x.value;
        }
        return null;
    }

    public void put(Key key, Value value){
        for (Node x = first; x != null; x = x.next){
            if (key.equals(x.key)){
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }

}
