package com.json.test.entities;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.annotations.ColumnTransformer;

import java.io.IOException;

@Entity
@Table(name = "secondary_table")
@Data
public class JsonbEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "jsonb")
    private String jsonData;



}