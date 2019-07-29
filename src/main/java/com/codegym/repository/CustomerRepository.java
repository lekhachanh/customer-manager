package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements GeneralRepository <Customer>{
    ArrayList<Customer> customerList = new ArrayList<>();
    {
        customerList.add(new Customer(1, "Ibrahimovic", "ibrahimovic@gmail.com", "LA galaxy"));
        customerList.add(new Customer(2, "Cristian Ronaldo", "CristianRonaldo@gmail.com", "Juventus"));
        customerList.add(new Customer(3, "mesut Osil", "mesutOsil@gmail.com", "Arsenal"));
        customerList.add(new Customer(4, "Leo Messi", "messi@gmail.com", "Barcelona"));
        customerList.add(new Customer(5, "Delight", "Delight@gmail.com", "Juventus"));
        customerList.add(new Customer(6, "Lampard", "Lampard@gmail.com", "Chelsea"));
        customerList.add(new Customer(7, "Torres", "Torres@gmail.com", "Liverpool"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerList.set(id, customer);
    }

    @Override
    public void remove(int id) {
        customerList.remove(id);
    }
}
