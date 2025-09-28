package com.example.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        // List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        // interceptors.add((request, body, execution) -> {
        //     request.getHeaders().add("User-Agent", "NVD-Client/1.0 (contact: example@example.com)");
        //     return execution.execute(request, body);
        // });
        // restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}

