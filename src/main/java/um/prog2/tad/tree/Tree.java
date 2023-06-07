package um.prog2.tad.tree;

public class Tree<K,T> implements MyTree<K,T> {

    private Node<K,T>raiz;

    public Tree() {
        this.raiz = null;
    }

    @Override
    public T find(K key) {
        if(raiz==null)
        {
            return null;
        }
        else{
            return raiz.find(key);
        }
    }

    @Override
    public boolean insert(K key, T data, K parentKey) {
        boolean seInserto=true;
        if(raiz==null)
        {
            raiz=new Node<>(parentKey,null);
            raiz.setLeftChild(new Node<>(key,data));
        }
        else {
            seInserto = raiz.insert(key, data, parentKey);
        }
        return seInserto;
    }

    @Override
    public void delete(K key) {
        if(raiz!=null)
        {
            if(raiz.getKey().equals(key))
            {
                raiz=null;
            }
            else{
                raiz.delete(key);
            }
        }
    }
}
