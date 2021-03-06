package __test__;

import model.Vehicle;
import model.logic.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Queue_Test {
    private Queue<Vehicle> queue;

    void setup() {
        queue = new Queue<>(Vehicle.compPlate);

        queue.enqueue(new Vehicle("qwe123", "qwe", "qwe", "qwe"));
        queue.enqueue(new Vehicle("asd123", "asd", "asd", "asd"));
        queue.enqueue(new Vehicle("zxc123", "zxc", "zxc", "zxc"));
        queue.enqueue(new Vehicle("ewq321", "ewq", "ewq", "ewq"));
        queue.enqueue(new Vehicle("dsa321", "dsa", "dsa", "dsa"));
    }

    @Test
    void size() {
        setup();
        Assertions.assertEquals(5, queue.size());
    }

    @Test
    void addQueue() {
        setup();
        Vehicle enqueuedVehicle = queue.enqueue(new Vehicle("cxz321", "cxz", "cxz", "cxz"));
        Assertions.assertEquals(6, queue.size());
        Assertions.assertEquals("cxz321", enqueuedVehicle.getPlate());
        enqueuedVehicle = queue.enqueue(new Vehicle("rty123", "rty", "rty", "rty"));
        Assertions.assertEquals(7, queue.size());
        Assertions.assertEquals("rty123", enqueuedVehicle.getPlate());
    }

    @Test
    void removeQueue() {
        setup();
        Vehicle deletedNode = queue.dequeue();
        Assertions.assertEquals(4, queue.size());
        Assertions.assertEquals("qwe123", deletedNode.getPlate());
        deletedNode = queue.dequeue();
        Assertions.assertEquals(3, queue.size());
        Assertions.assertEquals("asd123", deletedNode.getPlate());
    }


    @Test
    void peek() {
        setup();
        Vehicle peekedNode = queue.peek();
        Assertions.assertEquals("qwe123", peekedNode.getPlate());
        queue.dequeue();
        peekedNode = queue.peek();
        Assertions.assertEquals("asd123", peekedNode.getPlate());
    }

    @Test
    void peekLast() {
        setup();
        Vehicle peekedNode = queue.peekLast();
        Assertions.assertEquals("dsa321", peekedNode.getPlate());
        queue.enqueue(new Vehicle("cxz321", "cxz", "cxz", "cxz"));
        peekedNode = queue.peekLast();
        Assertions.assertEquals("cxz321", peekedNode.getPlate());
    }

    @Test
    void findQueue() {
        setup();
        Vehicle foundNode = queue.findNode(new Vehicle("qwe123", "qwe", "qwe", "qwe")).getData();
        Assertions.assertEquals("qwe123", foundNode.getPlate());
        foundNode = queue.findNode(new Vehicle("asd123", "asd", "asd", "asd")).getData();
        Assertions.assertEquals("asd123", foundNode.getPlate());
    }


    @Test
    void clearQueue() {
        setup();
        queue.clear();
        Assertions.assertEquals(0, queue.size());
        Assertions.assertTrue(queue.isEmpty());
    }

}
