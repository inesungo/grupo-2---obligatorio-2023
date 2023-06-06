package um.prog2.tad.listagenericos;

public class GenericNode<T>
{
    private GenericNode<T> next;
    private T data;

    public GenericNode()
    {

    }

    public GenericNode(T data)
    {
        this.data =  data;
    }

    public GenericNode<T> getNext()
    {
        return this.next;
    }

    public void setNext(GenericNode<T> node)
    {
        this.next = node;
    }

    public T getData()
    {
        return this.data;
    }

    public void setData(T data)
    {
        this.data = data;
    }
}
