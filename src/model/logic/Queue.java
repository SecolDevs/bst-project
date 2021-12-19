package model.logic;


import java.util.ArrayList;
import java.util.Comparator;

public class Queue<T> {
    private QueueNode<T> head;
    private QueueNode<T> tail;
    private Comparator<T> comparator;
    private int size;

    /**
     * Constructor for Queue
     *
     * @param comparator
     */
    public Queue(Comparator<T> comparator) {
        this.comparator = comparator;
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds an item to the queue
     *
     * @param T data to add
     * @return T
     */
    public T enqueue(T data) {
        QueueNode<T> node = new QueueNode<>(data);
        if (this.head == null) this.head = node;
        else this.tail.setNext(node);
        this.tail = node;
        this.size++;
        return data;
    }

    /**
     * Removes an item from the queue
     *
     * @return T
     */
    public T dequeue() {
        if (this.head == null) return null;
        T data = this.head.getData();
        this.head = this.head.getNext();
        this.size--;
        return data;
    }

    /**
     * Returns the size of the queue
     *
     * @return int
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns if the queue is empty
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns the head of the queue
     *
     * @return T
     */
    public T peek() {
        if (this.head == null) return null;
        return this.head.getData();
    }

    /**
     * Returns the tail of the queue
     *
     * @return T
     */
    public T peekLast() {
        if (this.tail == null) return null;
        return this.tail.getData();
    }


    /**
     * Returns a finded queue node
     *
     * @param T data to find
     * @return QueueNode
     */
    public QueueNode<T> findNode(T data) {
        QueueNode<T> current = this.head;
        while (current != null) {
            if (this.comparator.compare(current.getData(), data) == 0) return current;
            current = current.getNext();
        }
        return null;
    }

    /**
     * Returns the queue as an arrayList
     *
     * @return ArrayList<T>
     */
    public ArrayList<T> listQueue() {
        ArrayList<T> outList = new ArrayList<>();
        QueueNode<T> current = this.head;
        while (current != null) {
            outList.add(current.getData());
            current = current.getNext();
        }
        return outList;
    }


    /**
     * Returns the queue from node as an arrayList
     *
     * @param QueueNode<T> a list of nodes
     * @return ArrayList<T>
     */
    public ArrayList<T> listQueue(QueueNode<T> node) {
        ArrayList<T> outList = new ArrayList<>();
        QueueNode<T> current = node;
        while (current != null) {
            outList.add(current.getData());
            current = current.getNext();
        }
        return outList;
    }

    /**
     * Clears all the queue
     */
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

}
