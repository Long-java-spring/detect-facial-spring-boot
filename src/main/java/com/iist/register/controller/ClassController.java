package com.iist.register.controller;

import com.iist.register.dto.ClassDTO;
import com.iist.register.service.ClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classes")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ClassDTO classDTO) {
        classService.create(classDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
