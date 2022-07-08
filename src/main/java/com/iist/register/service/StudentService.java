package com.iist.register.service;

import com.iist.register.dto.StudentDTO;
import com.iist.register.entity.Class;
import com.iist.register.entity.Student;
import com.iist.register.exception.EntityNotFoundException;
import com.iist.register.repository.ClassRepository;
import com.iist.register.repository.ClockRepository;
import com.iist.register.repository.StudentRepository;
import com.iist.register.security.AuthTokenFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ClockRepository clockRepository;

    public void create(StudentDTO studentDTO) {
        Optional<Class> classOptional = classRepository.findById(studentDTO.getClassId());
        if (!classOptional.isPresent()) {
            throw new EntityNotFoundException("Class", studentDTO.getClassId());
        }
        try {
            studentRepository.save(new Student(studentDTO));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public String getMostRecentDetectFacial(Long studentId, String startAt, String endAt) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (!studentOptional.isPresent()) {
            throw new EntityNotFoundException("Student", studentId);
        }

        LocalDateTime ldtStartAt = LocalDate.parse(startAt).atStartOfDay();
        LocalDateTime ldtEndAt = LocalDate.parse(endAt).atStartOfDay().plusDays(1);

        return clockRepository.getMostRecentDetectTime(studentId, ldtStartAt, ldtEndAt);
    }
}
