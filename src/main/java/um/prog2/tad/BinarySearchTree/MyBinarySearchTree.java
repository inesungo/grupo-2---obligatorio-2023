package um.prog2.tad.BinarySearchTree;

import java.util.List;

public interface MyBinarySearchTree<K extends Comparable<K>,T> {
    T find(K key);
    boolean insert(K key,T data);

    void delete(K key);
    List<K> posOrder();
    List<K>inOrder();
    List<K>preOrder();
}
