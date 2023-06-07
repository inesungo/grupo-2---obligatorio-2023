package um.prog2.tad.tree;

public interface MyTree<K,T> {
    T find(K key);
    boolean insert(K key,T data,K parentKey);

    void delete(K key);

}
