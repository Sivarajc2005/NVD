package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.Cve;

public interface CveRepository extends JpaRepository<Cve, String> {
    
}
