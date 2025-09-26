package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.Metrics;

public interface MetricsRepository extends JpaRepository<Metrics, Long> {
    
}
