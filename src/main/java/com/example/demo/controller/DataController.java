package com.example.demo.controller;

import com.example.demo.model.DataEntity;
import com.example.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    private DataService dataService;

    @PostMapping
    public void saveData(@RequestBody String data) {
        dataService.saveData(data);
    }

    @GetMapping
    public Iterable<DataEntity> getAllData() {
        return dataService.getAllData();
    }
}
