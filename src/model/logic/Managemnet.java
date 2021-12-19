package model.logic;

import model.Vehicle;

import java.util.ArrayList;

public class Managemnet {
    private BinaryTree<Vehicle> tree;
    private Queue<Vehicle> queue;

    /**
     * Constructor for Management class
     */
    public Managemnet() {
        tree = new BinaryTree<>(Vehicle.compPlate);
        queue = new Queue<>(Vehicle.compPlate);
    }

    /**
     * Adds a vehicle to the queue and tree retunr true if vehicle was added, false otherwise
     *
     * @param vehicle vehicle to be added
     * @return boolean
     */
    public boolean addVehicle(Vehicle vehicle) {
        if (tree.findNode(vehicle) == null) {
            tree.addNode(queue.enqueue(vehicle));
            return true;
        }
        return false;
    }

    /**
     * Removes the first vehicle from the queue and then the tree return true if vehicle was removed, false otherwise
     *
     * @return boolean
     */
    public boolean removeVehicle() {
        Vehicle deletedVehicle = queue.dequeue();
        if (deletedVehicle != null) {
            tree.deleteNode(tree.findNode(deletedVehicle));
            return true;
        }
        return false;
    }

    /**
     * Finds a vehicle in the tree
     *
     * @param string plate of vehicle
     * @return vehicle
     */
    public Vehicle findVehicleTree(String plate) {
        ArrayList<Vehicle> list = tree.listInsort();
        for (Vehicle vehicle : list) {
            if (vehicle.getPlate().equals(plate)) return vehicle;
        }
        return null;
    }

    /**
     * Finds a vehicle in the queue
     *
     * @param string plate of vehicle
     * @return vehicle
     */
    public Vehicle findVehicleQueue(String plate) {
        for (Vehicle vehicle : queue.listQueue()) {
            if (vehicle.getPlate().equals(plate)) return vehicle;
        }
        return null;
    }

    /**
     * Returns an arraylist of vehicles in the tree
     *
     * @return string
     */
    public String listVehiclesTree() {
        String str = "";
        ArrayList<Vehicle> list = tree.listInsort();
        for (Vehicle vehicle : list) {
            str += vehicle.toString() + "\n";
        }
        return str;
    }

    /**
     * Returns an arraylist of vehicles in the queue
     *
     * @return string
     */
    public String listVehiclesQueue() {
        String str = "";
        for (Vehicle vehicle : queue.listQueue()) {
            str += vehicle.toString() + "\n";
        }
        return str;
    }

    /**
     * Returns an arraylist of vehicles in the queue from certain node
     *
     * @param String node to start from
     * @return string
     */
    public String listVehiclesQueueNode(String plate) {
        String str = "";
        for (Vehicle vehicle : queue.listQueue(queue.findNode(findVehicleQueue(plate)))) {
            str += vehicle + "\n";
        }
        return str;
    }

}
