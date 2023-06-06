import logica.MyTree;
import logica.Tree;

public class Main {
    public static void main(String[] args) {

        MyTree<String,String>abb=new Tree<>();
        abb.insert("AAA-123","Fiat","AAA-1111");
        abb.insert("AAA-124","Chery","AAA-1111");
        abb.insert("AAA-125","Chery","AAA-1111");
        abb.insert("AAA-126","Mercedes","AAA-124");
        abb.delete("AAA-126");
        String marca=abb.find("AAA-126");
        System.out.println(marca);
    }
}