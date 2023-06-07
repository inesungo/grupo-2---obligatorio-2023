package um.prog2.tad.tree;

public class Node<K,T> {
    private K key;
    private T data;

    private Node<K,T> leftChild;
    private Node<K,T>rightChild;

    public Node(K key, T data) {
        this.key = key;
        this.data = data;
        leftChild=null;
        rightChild=null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<K, T> rightChild) {
        this.rightChild = rightChild;
    }

    public T find(K key)
    {
        T dato=null;
        if(this.key.equals(key))
        {
            dato=this.data;
        }
        if(leftChild!=null && dato==null)
            dato=leftChild.find(key);

        if(rightChild!=null && dato==null)
            dato=rightChild.find(key);

        return dato;
    }

    public boolean insert(K key, T data, K parentKey) {
        boolean seInserto=false;
        if(this.key.equals(parentKey))
        {

            if(leftChild==null)
            {
                leftChild=new Node<>(key,data);
                seInserto=true;
            }
            else{
                if(rightChild==null)
                {
                    rightChild=new Node<>(key,data);
                    seInserto=true;
                }
            }
        }
        else{
            if(leftChild!=null)
            {
                seInserto=leftChild.insert(key,data,parentKey);
            }
            if(rightChild!=null && !seInserto)
            {
                seInserto=rightChild.insert(key,data,parentKey);
            }
        }
        return seInserto;
    }

    public void delete(K key) {
        if(leftChild!=null)
        {
            if(leftChild.getKey().equals(key))
            {
                leftChild=null;
            }
            else{
                leftChild.delete(key);
            }
        }
        if(rightChild!=null)
        {
            if(rightChild.getKey().equals(key))
            {
                rightChild=null;
            }
            else{
                rightChild.delete(key);
            }
        }
    }
}


