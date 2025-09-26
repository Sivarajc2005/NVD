package com.example.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Model.Vulnerabilities;
import com.example.Repository.CVSSDataRepository;
import com.example.Repository.ConfigurationsRepository;
import com.example.Repository.CpeMatchRepository;
import com.example.Repository.CveRepository;
import com.example.Repository.DescriptionsRepository;
import com.example.Repository.MetricsRepository;
import com.example.Repository.NodesRepository;
import com.example.Repository.VulnerabilitiesRepository;

@Repository
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

    

    
}
