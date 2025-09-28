package com.example.Model;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vulnerabilities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vulnerabilities {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "response_id")
    private NvdResponse nvdResponse;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cve_id")
    private Cve cve;
}
