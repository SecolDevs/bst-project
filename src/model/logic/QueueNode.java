package model.logic;

public class QueueNode<T> {
    private T data;
    private QueueNode<T> next;

    QueueNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public QueueNode<T> getNext() {
        return next;
    }

    public void setNext(QueueNode<T> next) {
        this.next = next;
    }
}
