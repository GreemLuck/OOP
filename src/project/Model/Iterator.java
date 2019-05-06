package project.Model;

import java.util.ListIterator;

public class Iterator<T> implements ListIterator {

    Node currentNode;
    int index;

    Iterator(int idx, MyLinkedList<T> list){
        this.index = idx;
        currentNode = list.head.next;

        while(idx>0){
            next();
            idx--;
        }
    }

    @Override
    public void add(Object o) {
        Node newNode = new Node<>(o);
        newNode.next = currentNode.next;
        newNode.previous = currentNode;

        currentNode.next = newNode;
        currentNode = newNode;
    }

    @Override
    public boolean hasNext() {
        if(currentNode.next.next == currentNode.next){
            return false;
        } else { return true;}
    }

    @Override
    public boolean hasPrevious() {
        if(currentNode.previous.previous == currentNode.previous){
            return false;
        } else { return true; }
    }

    @Override
    public int nextIndex() {
        if(hasNext()){
            return index + 1;
        } else {
            return -1;
        }
    }

    @Override
    public Object next() {
        currentNode = currentNode.next;
        return currentNode.content;
    }

    @Override
    public Object previous() {
        currentNode = currentNode.previous;
        return currentNode.content;
    }

    @Override
    public int previousIndex() {
        if(hasPrevious()){
            return index - 1;
        } else {
            return -1;
        }
    }

    @Override
    public void remove() {
        Node next = currentNode.next;
        Node previous = currentNode.previous;

        next.previous = previous;
        previous.next = next;

        if(hasNext()){
            currentNode = next;
        } else {
            currentNode = previous;
            index--;
        }
    }

    @Override
    public void set(Object o) {
        currentNode.content = o;
    }
}

