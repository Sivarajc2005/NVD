package com.example.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Entity
@Table(name = "cve")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cve {

    @Id
    private String id;

    private String sourceIdentifier;
    private String published;
    private String lastModified;
    private String vulnStatus;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cve_id")
    private List<Descriptions> descriptions;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "metrics_id")
    private Metrics metrics;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cve_id")
    private List<Configurations> configurations;
}

