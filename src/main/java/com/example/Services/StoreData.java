package com.example.Services;

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
import com.example.Repository.NvdResponseRepository;
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

    @Autowired
    public NvdResponseRepository nvdResponseRepository;

    public String saveVulnerability(String url) {
        NvdResponse data = restTemplate.getForObject(url, NvdResponse.class);

        // Attach parent-child relationships before saving
        if (data.getVulnerabilities() != null) {
            for (Vulnerabilities v : data.getVulnerabilities()) {
                v.setNvdResponse(data); // set parent
            }
        }

        // ✅ Save root entity
        NvdResponse saved = nvdResponseRepository.save(data);

        return "Saved " + saved.getVulnerabilities().size() + " vulnerabilities";
    }
}
