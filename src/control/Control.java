package control;

import model.Vehicle;
import model.logic.Managemnet;
import view.View;


public class Control {
    private View view;
    private Managemnet mng;

    /**
     * Constructor for objects of class Control
     */
    public Control() {
        view = new View();
        mng = new Managemnet();
    }

    /**
     * Redirects the menu of the program
     */
    public void initialMenu() {
        boolean check = true;
        int option = 0;
        while (check) {
            try {
                option = view.optionMenu();
            } catch (Exception e) {
                view.showMessageErr("Acción inválida");
            }
            switch (option) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    removeVehicle();
                    break;
                case 3:
                    searchVehicleTree();
                    break;
                case 4:
                    searchVehicleQueue();
                    break;
                case 5:
                    listQueue();
                    break;
                case 6:
                    listQueueNode();
                    break;
                case 7:
                    listTree();
                    break;
                case 8:
                    check = false;
                    break;
            }
        }
    }

    /**
     * List all tree
     */
    private void listTree() {
        try {
            view.showMessage(mng.listVehiclesTree());
        } catch (Exception e) {
            view.showMessageErr(e.getMessage());
        }
    }

    /**
     * List all queue
     */
    private void listQueue() {
        try {
            view.showMessage(mng.listVehiclesQueue());
        } catch (Exception e) {
            view.showMessageErr(e.getMessage());
        }
    }

    /**
     * List all queue from node
     */
    private void listQueueNode() {
        try {
            String plate = view.readString("Ingrese la placa del Vehiculo (Ejemplo: xxx000)", "Buscar Vehiculo").toUpperCase();
            view.showMessage(mng.listVehiclesQueueNode(plate));
        } catch (NullPointerException npe) {
            view.showMessageErr("No encontrado");
        } catch (Exception e) {
            view.showMessageErr(e.getMessage());
        }
    }

    /**
     * Search vehicle in tree
     */
    private void searchVehicleTree() {
        try {
            String plate = view.readString("Ingrese la placa del Vehiculo (Ejemplo: xxx000)", "Buscar Vehiculo").toUpperCase();
            Vehicle vehicle = mng.findVehicleTree(plate);
            view.showMessage(vehicle.toString());
        } catch (NullPointerException npe) {
            view.showMessageErr("No encontrado");
        } catch (Exception e) {
            view.showMessageErr(e.getMessage());
        }
    }

    /**
     * Search vehicle in queue
     */
    private void searchVehicleQueue() {
        try {
            String plate = view.readString("Ingrese la placa del Vehiculo (Ejemplo: xxx000)", "Buscar Vehiculo").toUpperCase();
            Vehicle vehicle = mng.findVehicleQueue(plate);
            view.showMessage(vehicle.toString());
        } catch (NullPointerException npe) {
            view.showMessageErr("No encontrado");
        } catch (Exception e) {
            view.showMessageErr(e.getMessage());
        }
    }

    /**
     * Adds a vehicle
     */
    private void addVehicle() {
        try {
            String plate = view.readString("Ingrese la placa del Vehiculo (Ejemplo: xxx000)", "Ingreso de vehiculo").toUpperCase();
            String brand = view.readString("Ingrese marca del vehiculo", "Marca");
            String model = view.readString("Ingrese modelo del vehiculo", "Modelo");
            String color = view.readString("Ingrese color del vehiculo", "Color");
            Vehicle vehicle = new Vehicle(plate, brand, model, color);
            if (mng.addVehicle(vehicle)) view.showMessage("Vehiculo agregado");
            else view.showMessageErr("No se pudo agregar vehicle");
        } catch (Exception e) {
            view.showMessageErr(e.getMessage());
        }
    }

    /**
     * Removes a vehicle
     */
    private void removeVehicle() {
        try {
            if (mng.removeVehicle()) view.showMessage("Vehiculo eliminado");
            else view.showMessageErr("No se pudo eliminar");
        } catch (Exception e) {
            view.showMessageErr(e.getMessage());
        }
    }
}
