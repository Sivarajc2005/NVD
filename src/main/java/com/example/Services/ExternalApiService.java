package com.example.Services;

import org.hibernate.internal.util.MutableObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApiService {


    @Autowired
    private RestTemplate restTemplate;

    public String getJsonData(String url) {
        // Returns raw JSON as String
        return restTemplate.getForObject(url, String.class);
    }

    public MutableObject getMappedData(String url) {
        // Maps JSON directly to a Java object
        return restTemplate.getForObject(url, MutableObject.class);
    }
}

