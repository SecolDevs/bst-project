package model;


class Node<T> {
    private T data;
    private Node<T> next;

    Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

public class Queue<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void enqueue(T data) {
        Node<T> node = new Node<T>(data);
        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.setNext(node);
        }
        this.tail = node;
        this.size++;
    }

    public T dequeue() {
        if (this.head == null) return null;

        T data = this.head.getData();
        this.head = this.head.getNext();
        this.size--;
        return data;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T peek() {
        if (this.head == null) return null;
        return this.head.getData();
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

}
