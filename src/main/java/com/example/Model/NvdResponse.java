package com.example.Model;

import java.util.List;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Table(name = "NvdResponse")
@Data
public class NvdResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "nvdResponse", cascade = CascadeType.ALL)
    private List<Vulnerabilities> vulnerabilities;
    // getters & setters
}
