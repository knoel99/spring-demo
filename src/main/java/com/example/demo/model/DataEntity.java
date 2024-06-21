package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Table("data_entity")
public class DataEntity {
    @Id
    private Long id;
    private String data;
}
