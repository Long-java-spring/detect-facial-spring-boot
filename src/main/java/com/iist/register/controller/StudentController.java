package com.iist.register.controller;

import com.iist.register.dto.StudentDTO;
import com.iist.register.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody StudentDTO studentDTO) {
        studentService.create(studentDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}/most-recent-detect-facial")
    public ResponseEntity<String> getMostRecentDetectFacial(
            @PathVariable Long studentId,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        String dateTime = studentService.getMostRecentDetectFacial(studentId, startDate, endDate);
        return ResponseEntity.ok(dateTime);
    }
}
