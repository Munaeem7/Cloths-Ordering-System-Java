package com.example.oopproject;

import java.util.Objects;

public class Customer {
    private String name;
    private String email;
    private String ContactNo;
    private String password;


    public Customer(String name, String email, String contactNo, String password) {
        this.name = name;
        this.email = email;
        ContactNo = contactNo;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(ContactNo, customer.ContactNo) && Objects.equals(password, customer.password);
    }


    @Override
    public String toString() {
        return String.format(name+","+email+","+ContactNo+","+password);
    }
}
