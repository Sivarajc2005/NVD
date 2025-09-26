package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.Nodes;

public interface NodesRepository extends JpaRepository<Nodes, Long> {
    
}
