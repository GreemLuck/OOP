package project.Model;

import java.util.ListIterator;

public class MyLinkedList<T> extends java.util.AbstractSequentialList<T> {
    Node head;
    Node tail;
    private int size = 0;

    public MyLinkedList(){
        head = new Node<T>(null);
        tail = new Node<T>(null);

        head.previous = head;
        head.next = tail;

        tail.next = tail;
        tail.previous = head;
    }

    @Override
    public boolean add(T o) {
        Node<T> newNode = new Node<>(o);

        newNode.next = tail;
        newNode.previous = tail.previous;

        tail.previous.next = newNode;
        tail.previous = newNode;

        size++;
        return true;
    }

    @Override
    public T remove(int index) {
        Node<T> node = head.next;

        while (index>0){
            node = node.next;
            index--;
        }

        Node next = node.next;
        Node previous = node.previous;

        next.previous = previous;
        previous.next = next;

        size--;
        return node.content;
    }

    @Override
    public T get(int index) {
        Node<T> node = head.next;

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
        Node<T> node = head;

        while (index>0){
            node = node.next;
            index--;
        }

        Iterator<T> iterator = new Iterator<>(node);
        return iterator;
    }
}
