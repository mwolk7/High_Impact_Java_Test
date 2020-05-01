package com.example.JavaTest_HighImpact_MarianoWolk.model.request;

import com.example.JavaTest_HighImpact_MarianoWolk.model.Address;
import lombok.Getter;
import lombok.Setter;

/**
 * serves as the request body object for
 * the main controller
 */
@Getter
@Setter
public class ATMgetRequest {

    private Address address;
    private int distance;
    private String type;

    public Address getAddress() {return address;}
    public void setAddress(Address address) {this.address = address;}
    public int getDistance() {return distance;}
    public void setDistance(int distance) {this.distance = distance;}
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
}
