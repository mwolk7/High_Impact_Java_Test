package com.example.JavaTest_HighImpact_MarianoWolk.model;

import lombok.Getter;
import lombok.Setter;

/**
 * main POJO used on this project's methods
 * serves as a representation of an ATM
 */
@Getter
@Setter
public class ATM {

    private Address address;
    private int distance;
    private String type;


    public ATM(Address address, int distance, String type) {
        this.address = address;
        this.distance = distance;
        this.type = type;
    }

    public ATM() {}
    public Address getAddress() {return address;}
    public void setAddress(Address address) {this.address = address;}
    public int getDistance() {return distance;}
    public void setDistance(int distance) {this.distance = distance;}
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
}
