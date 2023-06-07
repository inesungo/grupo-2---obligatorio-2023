package um.prog2.tad.BinarySearchTree;

import java.util.List;

public class NodeBST<K extends Comparable<K>,T> {
    private K key;
    private T data;

    private NodeBST<K,T> leftChild;
    private NodeBST<K,T> rightChild;

    public NodeBST(K key, T data) {
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

    public NodeBST<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodeBST<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public NodeBST<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodeBST<K, T> rightChild) {
        this.rightChild = rightChild;
    }

    public T find(K key)
    {
        if(this.getKey().compareTo(key)==0) {
            return this.getData();

        }
        else
        if (this.getKey().compareTo(key) > 0) {
            if (this.getLeftChild() == null) {
                return null;
            } else {
                return  this.getLeftChild().find(key);
            }
        } else {
            if (this.getRightChild() == null) {
                return null;
            } else {
                return this.getRightChild().find(key);
            }
        }
    }

    public boolean insert(K key, T data) {
        boolean seInserto=false;
        if(this.getKey().compareTo(key)!=0) {
            if (this.getKey().compareTo(key) > 0) {
                if (this.getLeftChild() == null) {
                    this.setLeftChild(new NodeBST<>(key, data));
                    seInserto = true;
                } else {
                    seInserto = this.getLeftChild().insert(key, data);
                }
            } else {
                if (this.getRightChild() == null) {
                    this.setRightChild(new NodeBST<>(key, data));
                } else {
                    seInserto = this.getRightChild().insert(key, data);
                }
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

    public NodeBST<K,T> max() {
        if(rightChild.getRightChild()==null)
        {
            NodeBST<K,T>aux=rightChild;
            rightChild=rightChild.getLeftChild();
            return aux;
        }
        else{
            return rightChild.max();

        }
    }

    public void preOrder(List<K> retorno) {
        retorno.add(key);//Pre
        if(leftChild!=null)
        {
            leftChild.preOrder(retorno);
        }
        //in
        if(rightChild!=null)
        {
            rightChild.preOrder(retorno);
        }
        //pos
    }
    public void inOrder(List<K> retorno) {

        if(leftChild!=null)
        {
            leftChild.inOrder(retorno);
        }
        //in
        retorno.add(key);//Pre
        if(rightChild!=null)
        {
            rightChild.inOrder(retorno);
        }
        //pos
    }

    public void posOrder(List<K> retorno) {

        if(leftChild!=null)
        {
            leftChild.posOrder(retorno);
        }
        //in

        if(rightChild!=null)
        {
            rightChild.posOrder(retorno);
        }
        //pos
        retorno.add(key);//Pre
    }
}


