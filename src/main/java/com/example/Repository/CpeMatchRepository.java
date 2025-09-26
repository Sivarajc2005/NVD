package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.CpeMatch;

public interface CpeMatchRepository extends JpaRepository<CpeMatch, Long> {
	
}
