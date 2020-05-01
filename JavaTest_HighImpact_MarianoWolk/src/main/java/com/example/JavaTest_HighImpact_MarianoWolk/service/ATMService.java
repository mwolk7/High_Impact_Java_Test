package com.example.JavaTest_HighImpact_MarianoWolk.service;

import com.example.JavaTest_HighImpact_MarianoWolk.model.ATM;
import com.example.JavaTest_HighImpact_MarianoWolk.model.request.ATMgetRequest;
import java.io.IOException;
import java.util.List;

/**
 * Main service interface providing all ATM related services
 * to be implemented by main service class
 */
public interface ATMService {

    List<ATM> getATMs(ATMgetRequest request) throws IOException;

}
