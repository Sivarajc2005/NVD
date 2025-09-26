package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.Model.Vulnerabilities;

public interface VulnerabilitiesRepository extends JpaRepository<Vulnerabilities , String>{
	
    @Query(value = "SELECT v FROM Vulnerabilities v WHERE v.id > :lastId ORDER BY v.id ASC")
    List<Vulnerabilities> listingVulnerability(@Param("lastId") String lastId, Pageable pageable);

}
