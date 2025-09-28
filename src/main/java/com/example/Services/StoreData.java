package com.example.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Model.NvdResponse;
import com.example.Model.Vulnerabilities;
import com.example.Repository.CVSSDataRepository;
import com.example.Repository.ConfigurationsRepository;
import com.example.Repository.CpeMatchRepository;
import com.example.Repository.CveRepository;
import com.example.Repository.DescriptionsRepository;
import com.example.Repository.MetricsRepository;
import com.example.Repository.NodesRepository;
import com.example.Repository.VulnerabilitiesRepository;

@Service
public class StoreData {
    
     @Autowired
    public VulnerabilitiesRepository vulnerabilitiesRepository;

    @Autowired
    public NodesRepository nodesRepository ;

    @Autowired
    public MetricsRepository metricsRepository;

    @Autowired
    public DescriptionsRepository descriptionsRepository;

    @Autowired
    public CVSSDataRepository cvssdataRepository;

    @Autowired
    public CveRepository cveRepository;

    @Autowired
    public CpeMatchRepository cpeMatchRepository;

    @Autowired
    public ConfigurationsRepository configurationsRepository; 

    @Autowired
    public RestTemplate restTemplate;

    public int saveVulnerability(String url) {
        NvdResponse data = restTemplate.getForObject(url , NvdResponse.class);
        
        if(data == null) {
            return 0;
        }

        List<Vulnerabilities> vulnerabilitieList = data.getVulnerabilities();
        int c = 0;
        if(vulnerabilitieList != null ){
            for(Vulnerabilities vulnerability : vulnerabilitieList){
                // Check if vulnerability has a valid ID and CVE data
                if(vulnerability.getId() != null && vulnerability.getCve() != null && vulnerability.getCve().getId() != null) {
                    // Use CVE ID as the primary identifier for checking existence
                    String cveId = vulnerability.getCve().getId();
                    
                    // Check if this CVE already exists in the database
                    if(!cveRepository.existsById(cveId)) {
                        // Save the vulnerability only if it doesn't exist
                        vulnerabilitiesRepository.save(vulnerability);
                        c++;
                    }
                }
            }
        }

        return c;

    }

    
}
