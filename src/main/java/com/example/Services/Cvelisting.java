package com.example.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.Model.Vulnerabilities;
import com.example.Repository.*;

@Service
public class Cvelisting {

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

    public static Vulnerabilities nextPage( int start , int range ){
        
        // Pageable pageable = pageRequest.of(start , range);
        // return VulnerabilitiesRepository.listingVulnerability(start , pageable);

        return null;
    }



}