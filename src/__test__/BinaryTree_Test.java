package __test__;

import model.Vehicle;
import model.logic.BinaryTree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinaryTree_Test {
    private BinaryTree<Vehicle> binaryTree;

    void setup() {
        binaryTree = new BinaryTree<>(Vehicle.compPlate);

        binaryTree.addNode(new Vehicle("qwe123", "qwe", "qwe", "qwe"));
        binaryTree.addNode(new Vehicle("asd123", "asd", "asd", "asd"));
        binaryTree.addNode(new Vehicle("zxc123", "zxc", "zxc", "zxc"));
        binaryTree.addNode(new Vehicle("ewq321", "ewq", "ewq", "ewq"));
        binaryTree.addNode(new Vehicle("dsa321", "dsa", "dsa", "dsa"));
    }

    @Test
    void size() {
        setup();
        Assertions.assertEquals(5, binaryTree.weightTree());
    }


    @Test
    void addTree() {
        setup();
        binaryTree.addNode(new Vehicle("cxz321", "cxz", "cxz", "cxz"));
        Assertions.assertEquals(6, binaryTree.weightTree());
        binaryTree.addNode(new Vehicle("rty123", "rty", "rty", "rty"));
        Assertions.assertEquals(7, binaryTree.weightTree());
    }

    @Test
    void removeTree() {
        setup();
        binaryTree.deleteNode(binaryTree.findNode(new Vehicle("qwe123", "qwe", "qwe", "qwe")));
        Assertions.assertEquals(4, binaryTree.weightTree());
        binaryTree.deleteNode(binaryTree.findNode(new Vehicle("asd123", "asd", "asd", "asd")));
        Assertions.assertEquals(3, binaryTree.weightTree());
    }


    @Test
    void findTree() {
        setup();
        Vehicle foundNode = binaryTree.findNode(new Vehicle("qwe123", "qwe", "qwe", "qwe")).getInfo();
        Assertions.assertEquals("qwe123", foundNode.getPlate());
        foundNode = binaryTree.findNode(new Vehicle("asd123", "asd", "asd", "asd")).getInfo();
        Assertions.assertEquals("asd123", foundNode.getPlate());
    }

}
