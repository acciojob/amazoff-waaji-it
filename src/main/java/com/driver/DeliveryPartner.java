package com.driver;
import java.util.ArrayList;
import java.util.List;
public class DeliveryPartner {

    private String id;
    private int numberOfOrders;
    private List<String> assignedOrders;

    public DeliveryPartner(String id) {
        this.id = id;
        this.numberOfOrders = 0;
        this.assignedOrders = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public Integer getNumberOfOrders(){
        return numberOfOrders;
    }

    public void setNumberOfOrders(Integer numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }
    public List<String> getAssignedOrders() {
        return assignedOrders;
    }

    public void addAssignedOrder(String orderId) {
        assignedOrders.add(orderId);
        numberOfOrders++;
    }

    public void removeAssignedOrder(String orderId) {
        assignedOrders.remove(orderId);
        numberOfOrders--;
    }
}