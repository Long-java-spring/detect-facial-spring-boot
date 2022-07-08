package com.iist.register.service;

import com.iist.register.dto.FacialSetupDTO;
import com.iist.register.dto.RecognitionResult;
import com.iist.register.entity.Student;
import com.iist.register.exception.EntityNotFoundException;
import com.iist.register.repository.StudentRepository;
import com.iist.register.shared.FacialRecognitionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecognitionService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClockService clockService;

    public void register(FacialSetupDTO facialSetupDTO) {
        Long userId = facialSetupDTO.getUserId();
        Optional<Student> studentOptional = studentRepository.findById(userId);
        if (!studentOptional.isPresent()) throw new EntityNotFoundException("Student", userId);

        FacialRecognitionUtil.prepareRegisterRequest(facialSetupDTO, studentOptional.get().getName());

        Student s = studentOptional.get();
        s.setFacialRecognitionStatus(true);
        studentRepository.save(s);
    }

    public void train() {
        FacialRecognitionUtil.prepareTrainRequest();
    }

    public String verify(FacialSetupDTO facialSetupDTO) throws Exception {
        RecognitionResult recognitionResult = FacialRecognitionUtil.prepareVerifyRequest(facialSetupDTO);
        Optional<Student> studentOptional = studentRepository.findById(Long.parseLong(recognitionResult.getPartId()));
        if (!studentOptional.isPresent()) throw new EntityNotFoundException("Student", Long.parseLong(recognitionResult.getPartId()));
        clockService.create(Long.parseLong(recognitionResult.getPartId()), (int) recognitionResult.getProbability());
        return studentOptional.get().getName();
    }
}
