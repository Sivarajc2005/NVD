package com.example.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "cpe_match")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CpeMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean vulnerable;
    private String criteria;
    private String matchCriteriaId;
}