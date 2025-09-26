package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Services.ExternalApiService;

@RestController
@RequestMapping("")
public class ExternalApiController {

    @Autowired
    private ExternalApiService service;

    @GetMapping("/")
    public String home(){
        return "Welcome to External API Controller";
    }

    @GetMapping("/fetch")
    public String fetchData() {
        String url = "https://services.nvd.nist.gov/rest/json/cves/2.0";
        return service.getJsonData(url);
    }
}

