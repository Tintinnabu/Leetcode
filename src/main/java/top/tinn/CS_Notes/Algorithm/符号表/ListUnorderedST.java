package top.tinn.CS_Notes.Algorithm.符号表;

public class ListUnorderedST<Key, Value> implements UnorderedST<Key, Value> {
    private Node first;

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

    @Override
    public int size() {
        int cnt = 0;
        Node cur = first;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }
        return cnt;
    }

    @Override
    public Value get(Key key) {
        Node cur = first;
        while (cur != null){
            if (cur.key.equals(key)){
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void put(Key key, Value value) {
        Node cur = first;
        while (cur != null){
            if (cur.key.equals(key)){
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        first = new Node(key, value, first);
    }

    @Override
    public void delete(Key key) {
        if (first == null){
            return;
        }
        if (first.key.equals(key)){
            first = first.next;
            return;
        }
        Node pre = first, cur = first.next;
        while (cur != null){
            if (cur.key.equals(key)){
                pre.next = cur.next;
            }
            pre = pre.next;
            cur = cur.next;
        }
    }
}
