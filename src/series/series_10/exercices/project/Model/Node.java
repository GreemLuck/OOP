package project.Model;

public class Node<T> {

    protected Node previous;
    protected Node next;
    protected T content;

    public Node(T content){ this.content = content;}
}
