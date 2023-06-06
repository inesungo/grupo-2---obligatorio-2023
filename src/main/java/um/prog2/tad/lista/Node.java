package um.prog2.tad.lista;

public class Node
{
    private Node next;
    private Object data;

    public Node()
    {

    }

    public Node(Object data)
    {
        this.data = data;
    }

    public Node getNext()
    {
        return this.next;
    }

    public void setNext(Node node)
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
