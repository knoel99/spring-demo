package com.example.demo.repository;

import com.example.demo.model.DataEntity;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<DataEntity, Long> {
}
