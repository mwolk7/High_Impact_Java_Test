package com.example.JavaTest_HighImpact_MarianoWolk.controller;

import com.example.JavaTest_HighImpact_MarianoWolk.model.ATM;
import com.example.JavaTest_HighImpact_MarianoWolk.model.request.ATMgetRequest;
import com.example.JavaTest_HighImpact_MarianoWolk.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RequestMapping("/api")
@RestController
public class ATMController {

    @Autowired
    ATMService atmService;

    /**
     * Main entry point to the app, receives a referential ATM param
     * in order to look up for a match up
     *
     * @param ATMgetRequest the request object
     * @return the list of matching ATMs according to request body params
     */
    @Validated
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/atms",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ATM> getATMs(@RequestBody ATMgetRequest request) throws IOException {
        return atmService.getATMs(request);
    }
}
