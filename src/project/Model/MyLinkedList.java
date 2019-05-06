package project.Model;

import java.util.ListIterator;

public class MyLinkedList<T> extends java.util.AbstractSequentialList {
    Node<T> head;
    Node<T> tail;
    private int size = 0;

    MyLinkedList(){
        head = new Node<>(null);
        tail = new Node<>(null);

        head.previous = head;
        head.next = tail;

        tail.next = tail;
        tail.previous = head;
    }

    @Override
    public boolean add(Object o) {
        Node newNode = new Node<>(o);
        newNode.previous = tail.previous;
        newNode.next = tail;

        tail.previous = newNode;
        return true;
    }

    @Override
    public Object remove(int index) {
        Node node = head.next;

        while (index>0){
            node = node.next;
            index--;
        }

        Node next = node.next;
        Node previous = node.previous;

        next.previous = previous;
        previous.next = next;

        return node.content;
    }

    @Override
    public Object get(int index) {
        Node node = head.next;

        while (index>0){
            node = node.next;
            index--;
        }

        return node.content;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ListIterator listIterator(int index) {
        return new Iterator(index, this);
    }
}
