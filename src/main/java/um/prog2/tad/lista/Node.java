package um.prog2.tad.lista;

public class Node<T> {
    private Node<T> next;
    private Object data;

    public Node()
    {

    }

    public Node(Object data)
    {
        this.data = data;
    }

    public Node<T> getNext()
    {
        return this.next;
    }

    public void setNext(Node<T> node)
    {
        this.next = node;
    }

    public Object getData()
    {
        return this.data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }
}
