package com.example.JavaTest_HighImpact_MarianoWolk.model;

import lombok.Getter;
import lombok.Setter;

/**
 * POJO representing the geolocation of an ATM
 */
@Getter
@Setter
public class Geolocation {

    private String lat;
    private String lng;

    public Geolocation(String lat, String lng) {this.lat = lat; this.lng = lng;}
    public Geolocation() {}
    public String getLat() {return lat; }
    public void setLat(String lat) {this.lat = lat;}
    public String getLng() {return lng;}
    public void setLng(String lng) {this.lng = lng;}
}
