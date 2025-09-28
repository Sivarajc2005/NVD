package com.example.Services;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;
// import org.springframework.web.util.UriComponentsBuilder;

// import com.example.Model.CVSSData;
// import com.example.Model.Configurations;
// import com.example.Model.CpeMatch;
// import com.example.Model.Cve;
// import com.example.Model.Descriptions;
// import com.example.Model.Metrics;
// import com.example.Model.Nodes;
// import com.example.Model.Vulnerabilities;
// import com.example.Repository.CveRepository;
// import com.example.Repository.VulnerabilitiesRepository;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;

@Service
public class ExternalApiService {

// 	@Autowired
// 	private RestTemplate restTemplate;

// 	@Autowired
// 	private CveRepository cveRepository;
// 	@Autowired
// 	private VulnerabilitiesRepository vulnerabilitiesRepository;

// 	public String getJsonData(String url) {
// 		// Returns raw JSON as String
// 		return restTemplate.getForObject(url, String.class);
// 	}

// 	public int fetchAndStore(String baseUrl) {
// 		String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
// 				.queryParam("resultsPerPage", 50)
// 				.queryParam("startIndex", 0)
// 				.build(true)
// 				.toUriString();

// 		Map response = restTemplate.getForObject(url, Map.class);
// 		if (response == null) return 0;

// 		List<Map<String, Object>> vulnerabilities = (List<Map<String, Object>>) response.get("vulnerabilities");
// 		if (vulnerabilities == null) return 0;

// 		int saved = 0;
// 		for (Map<String, Object> item : vulnerabilities) {
// 			Map<String, Object> cveMap = (Map<String, Object>) item.get("cve");
// 			if (cveMap == null) continue;

// 			String cveId = (String) cveMap.get("id");
// 			if (cveId == null) continue;

// 			Cve cve = new Cve();
// 			cve.setId(cveId);
// 			cve.setSourceIdentifier((String) cveMap.get("sourceIdentifier"));
// 			cve.setPublished((String) cveMap.get("published"));
// 			cve.setLastModified((String) cveMap.get("lastModified"));
// 			cve.setVulnStatus((String) cveMap.get("vulnStatus"));

// 			List<Map<String, String>> descriptionsList = (List<Map<String, String>>) cveMap.get("descriptions");
// 			List<Descriptions> descriptionsEntities = new ArrayList<>();
// 			if (descriptionsList != null) {
// 				for (Map<String, String> d : descriptionsList) {
// 					Descriptions desc = new Descriptions();
// 					desc.setLang(d.get("lang"));
// 					desc.setValue(d.get("value"));
// 					descriptionsEntities.add(desc);
// 				}
// 			}
// 			cve.setDescriptions(descriptionsEntities);

// 			Map<String, Object> metricsTop = (Map<String, Object>) cveMap.get("metrics");
// 			Metrics metricsEntity = null;
// 			if (metricsTop != null) {
// 				List<Map<String, Object>> cvssMetricV2 = (List<Map<String, Object>>) metricsTop.get("cvssMetricV2");
// 				if (cvssMetricV2 != null && !cvssMetricV2.isEmpty()) {
// 					Map<String, Object> m = cvssMetricV2.get(0);
// 					Map<String, Object> cvssData = (Map<String, Object>) m.get("cvssData");
// 					metricsEntity = new Metrics();
// 					if (cvssData != null) {
// 						CVSSData cvss = new CVSSData();
// 						cvss.setVectorString((String) cvssData.get("vectorString"));
// 						Number baseScore = (Number) cvssData.get("baseScore");
// 						cvss.setBaseScore(baseScore == null ? null : baseScore.floatValue());
// 						cvss.setAccessVector((String) cvssData.get("accessVector"));
// 						cvss.setAccessComplexity((String) cvssData.get("accessComplexity"));
// 						cvss.setAuthentication((String) cvssData.get("authentication"));
// 						cvss.setConfidentialityImpact((String) cvssData.get("confidentialityImpact"));
// 						cvss.setIntegrityImpact((String) cvssData.get("integrityImpact"));
// 						cvss.setAvailabilityImpact((String) cvssData.get("availabilityImpact"));
// 						metricsEntity.setCvssData(cvss);
// 					}
// 					metricsEntity.setBaseSeverity((String) m.get("baseSeverity"));
// 					Number exploitabilityScore = (Number) m.get("exploitabilityScore");
// 					metricsEntity.setExploitabilityScore(exploitabilityScore == null ? null : exploitabilityScore.floatValue());
// 					Number impactScore = (Number) m.get("impactScore");
// 					metricsEntity.setImpactScore(impactScore == null ? null : impactScore.floatValue());
// 				}
// 			}
// 			cve.setMetrics(metricsEntity);

// 			List<Configurations> configurationsEntities = new ArrayList<>();
// 			List<Map<String, Object>> configurationsList = (List<Map<String, Object>>) cveMap.get("configurations");
// 			if (configurationsList != null) {
// 				for (Map<String, Object> conf : configurationsList) {
// 					Configurations confEntity = new Configurations();
// 					List<Nodes> nodeEntities = new ArrayList<>();
// 					List<Map<String, Object>> nodes = (List<Map<String, Object>>) conf.get("nodes");
// 					if (nodes != null) {
// 						for (Map<String, Object> node : nodes) {
// 							Nodes nodeEntity = new Nodes();
// 							nodeEntity.setOperator((String) node.get("operator"));
// 							nodeEntity.setNegate((Boolean) node.get("negate"));
// 							List<CpeMatch> cpeMatchEntities = new ArrayList<>();
// 							List<Map<String, Object>> cpeMatchList = (List<Map<String, Object>>) node.get("cpeMatch");
// 							if (cpeMatchList != null) {
// 								for (Map<String, Object> cm : cpeMatchList) {
// 									CpeMatch cpe = new CpeMatch();
// 									cpe.setVulnerable((Boolean) cm.get("vulnerable"));
// 									cpe.setCriteria((String) cm.get("criteria"));
// 									cpe.setMatchCriteriaId((String) cm.get("matchCriteriaId"));
// 									cpeMatchEntities.add(cpe);
// 								}
// 							}
// 							nodeEntity.setCpeMatch(cpeMatchEntities);
// 							nodeEntities.add(nodeEntity);
// 						}
// 					}
// 					confEntity.setNodes(nodeEntities);
// 					configurationsEntities.add(confEntity);
// 				}
// 			}
// 			cve.setConfigurations(configurationsEntities);

// 			Vulnerabilities vuln = new Vulnerabilities();
// 			vuln.setId(cveId);
// 			vuln.setCve(cve);

// 			if (!vulnerabilitiesRepository.existsById(cveId)) {
// 				vulnerabilitiesRepository.save(vuln);
// 				saved++;
// 			}
// 		}

// 		return saved;
// 	}
}

