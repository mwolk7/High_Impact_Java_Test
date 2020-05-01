package com.example.JavaTest_HighImpact_MarianoWolk.utils;

import com.example.JavaTest_HighImpact_MarianoWolk.model.ATM;
import com.example.JavaTest_HighImpact_MarianoWolk.model.Address;
import com.example.JavaTest_HighImpact_MarianoWolk.model.Geolocation;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Jackson based utility object mapper used to obtain the ATMs from
 * the established source(URL in this case) and map them for later usage
 *
 * @return mapped ATMs list
 */
public class ObjectMapper {

    private static final String ATMs_URL = "https://www.dropbox.com/s/6fg0k2wxwrheyqk/ATMs?dl=1";

    public static List<ATM> jsonToATM() throws IOException {

        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        List<HashMap<String, Object>> JSONList;
        List<ATM> ATMList = new ArrayList<>();
        JSONList = mapper.readValue(new URL(ATMs_URL), ArrayList.class);

        JSONList.stream().forEach(atmMap -> {

            Geolocation geolocation = new Geolocation();
            Address address = new Address();
            ATM atm = new ATM();
            HashMap<String, Object> addressMap = (HashMap<String, Object>) atmMap.get("address");
            HashMap<String, String> geolocationMap = (HashMap<String, String>) addressMap.get("geoLocation");

            geolocation.setLat((geolocationMap.get("lat")));
            geolocation.setLng((geolocationMap.get("lng")));
            address.setStreet(String.valueOf(addressMap.get("street")));
            address.setHousenumber(String.valueOf(addressMap.get("housenumber")));
            address.setPostalcode(String.valueOf(addressMap.get("postalcode")));
            address.setCity(String.valueOf(addressMap.get("city")));
            address.setGeoLocation(geolocation);
            atm.setAddress(address);
            atm.setDistance(Integer.parseInt(String.valueOf(atmMap.get("distance"))));
            atm.setType(String.valueOf(atmMap.get("type")));
            ATMList.add(atm);
        });

        return ATMList;
    }
}
