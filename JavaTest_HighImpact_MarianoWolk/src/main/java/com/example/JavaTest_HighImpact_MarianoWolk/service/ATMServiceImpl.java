package com.example.JavaTest_HighImpact_MarianoWolk.service;

import com.example.JavaTest_HighImpact_MarianoWolk.model.ATM;
import com.example.JavaTest_HighImpact_MarianoWolk.model.Address;
import com.example.JavaTest_HighImpact_MarianoWolk.model.Geolocation;
import com.example.JavaTest_HighImpact_MarianoWolk.model.request.ATMgetRequest;
import com.example.JavaTest_HighImpact_MarianoWolk.utils.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Main service class providing all ATM related services
 */
@Service
public class ATMServiceImpl implements ATMService {

    /**
     * Receives a referential ATM in order to look for
     * a match and return the result in a list with a JSON format
     *
     * @param ATMgetRequest received as external parameter
     * @return list of obtained matched ATMs
     */
    @Override
    public List<ATM> getATMs(ATMgetRequest request) throws IOException {

        Geolocation requestGeolocation = new Geolocation(request.getAddress().getGeoLocation().getLat(), request.getAddress().getGeoLocation().getLng());
        Address requestAddress = new Address(request.getAddress().getStreet(), request.getAddress().getHousenumber(), request.getAddress().getPostalcode(), request.getAddress().getCity(), requestGeolocation);
        ATM paramATM = new ATM(requestAddress, request.getDistance(), request.getType());

        return searchMatchingATMs(paramATM);
    }

    /**
     * Lookup for all matching ATMs
     *
     * @param ATM referential ATM to check for a match
     * @return list of obtained matched ATMs
     */
    public List<ATM> searchMatchingATMs(ATM paramATM) throws IOException {

        Optional<List<ATM>> matchingATMs = Optional.of(new ArrayList());
        if (matchingATMs.isPresent()) {
            List<ATM> atmList = (ObjectMapper.jsonToATM());
            atmList.stream()
                    .forEach(atm -> {
                        if (compareATMs(paramATM, atm)) {
                            matchingATMs.get().add(atm);
                        }
                    });
        }

        return matchingATMs.get();
    }

    /**
     * ATM comparator for all fields
     *
     * @param paramATM base reference ATM
     * @param atm      second atm for comparison purposes
     * @return true if both reference and looked up ATM/s match
     */
    private boolean compareATMs(ATM paramATM, ATM atm) {
        //TODO refactor later for better legibility / cleaner code
        return ("".equalsIgnoreCase(paramATM.getAddress().getStreet()) || atm.getAddress().getStreet().equalsIgnoreCase(paramATM.getAddress().getStreet()))

                && ("".equalsIgnoreCase(paramATM.getAddress().getHousenumber()) || atm.getAddress().getHousenumber().equalsIgnoreCase(paramATM.getAddress().getHousenumber()))

                && ("".equalsIgnoreCase(paramATM.getAddress().getPostalcode()) || atm.getAddress().getPostalcode().equalsIgnoreCase(paramATM.getAddress().getPostalcode()))

                && ("".equalsIgnoreCase(paramATM.getAddress().getCity()) || atm.getAddress().getCity().equalsIgnoreCase(paramATM.getAddress().getCity()))

                && (null == paramATM.getAddress().getGeoLocation() || "".equalsIgnoreCase(paramATM.getAddress().getGeoLocation().getLat()) || atm.getAddress().getGeoLocation().getLat().equalsIgnoreCase(paramATM.getAddress().getGeoLocation().getLat()))

                && (null == paramATM.getAddress().getGeoLocation() || "".equalsIgnoreCase(paramATM.getAddress().getGeoLocation().getLng()) || atm.getAddress().getGeoLocation().getLng().equalsIgnoreCase(paramATM.getAddress().getGeoLocation().getLng()))

                && (-1 == paramATM.getDistance() || atm.getDistance() == (paramATM.getDistance()))

                && ("".equalsIgnoreCase(paramATM.getType()) || atm.getType().equalsIgnoreCase(paramATM.getType()));
    }
}
