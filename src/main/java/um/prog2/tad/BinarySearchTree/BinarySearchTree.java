package um.prog2.tad.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
public class BinarySearchTree<K extends Comparable<K>,T> implements MyBinarySearchTree<K,T> {

    private NodeBST<K,T> raiz;

    public BinarySearchTree() {
        this.raiz = null;
    }

    @Override
    public T find(K key) {
        if(raiz==null)
        {
            return null;
        }
        else {
            if(raiz.getKey().compareTo(key)==0) {
                return raiz.getData();

            }
            else
                if (raiz.getKey().compareTo(key) > 0) {
                    if (raiz.getLeftChild() == null) {
                        return null;
                    } else {
                        return  raiz.getLeftChild().find(key);
                    }
                } else {
                    if (raiz.getRightChild() == null) {
                        return null;
                    } else {
                       return raiz.getRightChild().find(key);
                    }
                }
            }




    }

    @Override
    public boolean insert(K key, T data) {
        boolean seInserto=false;
        if(raiz==null)
        {
           raiz=new NodeBST<>(key,data);
           seInserto=true;
        }
        else {
            if(raiz.getKey().compareTo(key)!=0)
            {
                if (raiz.getKey().compareTo(key) > 0) {
                    if (raiz.getLeftChild() == null) {
                        raiz.setLeftChild(new NodeBST<>(key, data));
                        seInserto = true;
                    } else {
                        seInserto = raiz.getLeftChild().insert(key, data);
                    }
                } else {
                    if (raiz.getRightChild() == null) {
                        raiz.setRightChild(new NodeBST<>(key, data));
                    } else {
                        seInserto = raiz.getRightChild().insert(key, data);
                    }
                }
            }


        }
        return seInserto;
    }

    @Override
    public void delete(K key) {
        if(raiz!=null)
        {
            if(raiz.getKey().equals(key))
            {
                if(raiz.getLeftChild()==null && raiz.getRightChild()==null)
                {
                    raiz=null;
                }
                else{
                    if(raiz.getLeftChild()==null)
                    {
                        raiz=raiz.getRightChild();
                    }
                    else{
                        if(raiz.getRightChild()==null)
                        {
                            raiz=raiz.getLeftChild();
                        }
                        else{
                            if(raiz.getLeftChild().getRightChild()==null)
                                raiz=raiz.getLeftChild();
                            else{
                                raiz=raiz.getLeftChild().max();
                            }
                        }
                    }
                }
            }
            else{

                    if (raiz.getKey().compareTo(key) > 0) {
                        if (raiz.getLeftChild() != null) {


                             raiz.getLeftChild().delete(key);
                        }
                    } else {
                        if (raiz.getRightChild() != null) {


                             raiz.getRightChild().delete(key);
                        }
                    }

            }
        }
    }
    public List<K>preOrder()
    {
        List<K>retorno=new ArrayList<>();
        if(raiz!=null)
        {
            raiz.preOrder(retorno);
        }
        return retorno;
    }

    public List<K>inOrder()
    {
        List<K>retorno=new ArrayList<>();
        if(raiz!=null)
        {
            raiz.inOrder(retorno);
        }
        return retorno;
    }

    public List<K>posOrder()
    {
        List<K>retorno=new ArrayList<>();
        if(raiz!=null)
        {
            raiz.posOrder(retorno);
        }
        return retorno;
    }
}


