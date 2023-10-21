package org.example.entity;

public class Node<T> {
    private T value;
    private Node<T> next;

    Node(){
        this.next = null;
        this.value = null;
    }

    Node(T value){
        this.next = null;
        this.value = value;
    }

    Node(T value, Node<T> next){
        this.next = next;
        this.value = value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public Node<T> getNext(){
        return next;
    }
}
