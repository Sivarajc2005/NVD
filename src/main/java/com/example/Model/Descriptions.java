package com.example.Model;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "descriptions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Descriptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lang;
    
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String value;
}

