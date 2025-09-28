package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Services.ExternalApiService;
import com.example.Services.StoreData;

@RestController
@RequestMapping("")
public class ExternalApiController {

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    private ExternalApiService externalApiService;

    @Autowired
    private StoreData storeData;

    @GetMapping("/")
    public String home(){
        return "Welcome to External API Controller";
    }

    @GetMapping("/fetch")
    public String fetchData() {
        String url = "https://services.nvd.nist.gov/rest/json/cves/2.0";
        // int saved = service.fetchAndStore(url);
        // NvdResponse data  = restTemplate.getForObject(url, NvdResponse.class);
        // System.out.println(data.vulnerabilities.size());
        
        return storeData.saveVulnerability(url);
    }
}

