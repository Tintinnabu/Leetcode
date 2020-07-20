package top.tinn.CS_Notes.Algorithm.符号表;

import java.util.List;

public interface OrderedST<Key extends Comparable<Key>, Value> {
    int size();

    void put(Key key, Value value);

    Value get(Key key);

    Key min();

    Key max();

    int rank(Key key);

    List<Key> keys(Key l, Key h);
}
