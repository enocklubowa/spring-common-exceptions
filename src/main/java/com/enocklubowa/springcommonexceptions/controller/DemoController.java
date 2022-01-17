package com.enocklubowa.springcommonexceptions.controller;

import com.enocklubowa.springcommonexceptions.DemoService;
import com.enocklubowa.springcommonexceptions.model.DemoEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exceptions")
public class DemoController {

    DemoService service;

    @PostMapping("")
    public ResponseEntity<Object> createEntity(@RequestBody DemoEntity entity){
        return new ResponseEntity<>(service.saveEntity(entity), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> createEntity(@RequestParam String id){
        return new ResponseEntity<>(service.getEntityById(id), HttpStatus.OK);
    }
}
