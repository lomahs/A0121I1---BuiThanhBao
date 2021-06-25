package models.services;

import models.entity.Customer;

/**
 * Project: FuramaResort
 * Package: models
 * User: lomahs
 * Date time: 23/06/2021 17:00
 * Created with IntelliJ IDEA
 */
public class Booking {
    private Customer customer;
    private Services service;

    public Booking() {
    }

    public Booking(Customer customer, Services service) {
        this.customer = customer;
        this.service = service;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }
}
