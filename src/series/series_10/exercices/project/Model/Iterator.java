package project.Model;

import java.util.ListIterator;

public class Iterator<T> implements ListIterator<T> {

    Node<T> currentNode;

    Iterator(Node<T> currentNode){
        this.currentNode = currentNode;
    }

    @Override
    public void add(T o) {
        Node<T> newNode = new Node<>(o);
        newNode.next = currentNode.next;
        newNode.previous = currentNode;

        currentNode.next = newNode;
        currentNode = newNode;
    }

    @Override
    public boolean hasNext() {
        if(currentNode.next == currentNode.next.next){
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
        if(!(hasNext())){
            return -1;
        }
        int index = 0;
        Iterator<T> i = new Iterator<>(currentNode);
        while(i.hasPrevious()){
            i.previous();
            index++;
        }
        return index + 1;
    }

    @Override
    public T next() {
        currentNode = currentNode.next;
        return currentNode.content;
    }

    @Override
    public T previous() {
        currentNode = currentNode.previous;
        return currentNode.content;
    }

    @Override
    public int previousIndex() {
        if(!(hasPrevious())){
            return -1;
        }
        int index = 0;
        Iterator<T> i = new Iterator<>(currentNode);
        while(i.hasPrevious()){
            i.previous();
            index++;
        }
        return index - 1;

    }

    @Override
    public void remove() {
        Node<T> next = currentNode.next;
        Node<T> previous = currentNode.previous;

        next.previous = previous;
        previous.next = next;

        if(hasNext()){
            currentNode = next;
        } else {
            currentNode = previous;
        }
    }

    @Override
    public void set(T o) {
        currentNode.content = o;
    }
}

