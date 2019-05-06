package project.Model;

public class Node<T> {

    protected Node previous;
    protected Node next;
    protected T content;

    Node(T content){ this.content = content;}
}
