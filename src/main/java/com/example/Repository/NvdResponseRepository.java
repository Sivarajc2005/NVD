package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.NvdResponse;

public interface  NvdResponseRepository extends JpaRepository<NvdResponse, Long> {
    
}
