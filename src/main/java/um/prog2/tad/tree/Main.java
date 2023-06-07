package um.prog2.tad.tree;

import um.prog2.tad.BinarySearchTree.BinarySearchTree;
import um.prog2.tad.BinarySearchTree.MyBinarySearchTree;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        MyTree<String,String>ab=new Tree<>();
        ab.insert("AAA-123","Fiat","AAA-1111");
        ab.insert("AAA-124","Chery","AAA-1111");
        ab.insert("AAA-125","Chery","AAA-1111");
        ab.insert("AAA-126","Mercedes","AAA-124");
        ab.delete("AAA-126");
        String marca=ab.find("AAA-126");
        System.out.println(marca);

        MyBinarySearchTree<Integer,Integer>abb=new BinarySearchTree<>();
        abb.insert(20,20);
        abb.insert(40,40);
        abb.insert(35,35);
        abb.insert(10,10);
        abb.insert(80,80);
        List<Integer>listado=abb.posOrder();
        for(Integer numero:listado){
            System.out.println(numero);
        }
    }
}