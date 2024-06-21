package com.example.demo.service;

import com.example.demo.model.DataEntity;
import com.example.demo.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    @Autowired
    private DataRepository dataRepository;

    public void saveData(String data) {
        DataEntity dataEntity = new DataEntity();
        dataEntity.setData(data);
        dataRepository.save(dataEntity);
    }

    public Iterable<DataEntity> getAllData() {
        return dataRepository.findAll();
    }
}
