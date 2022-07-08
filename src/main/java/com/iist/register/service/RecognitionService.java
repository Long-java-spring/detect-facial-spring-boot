package com.iist.register.service;

import com.iist.register.dto.FacialSetupDTO;
import com.iist.register.dto.RecognitionResult;
import com.iist.register.entity.Student;
import com.iist.register.exception.EntityNotFoundException;
import com.iist.register.repository.StudentRepository;
import com.iist.register.shared.FacialRecognitionUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    public void registerV2(Long userId, List<MultipartFile> file) {
        Optional<Student> studentOptional = studentRepository.findById(userId);
        if (!studentOptional.isPresent()) throw new EntityNotFoundException("Student", userId);
        List<String> images = new ArrayList<>(Collections.emptyList());
        file.forEach(multipartFile -> {
            try {
                String base64 = StringUtils.newStringUtf8(Base64.encodeBase64(multipartFile.getBytes()));
                images.add(base64);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        if (images.isEmpty()) return;

        FacialSetupDTO facialSetupDTO = new FacialSetupDTO(userId, images);
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

    public String verifyV2(MultipartFile file) throws Exception {
        String base64 = StringUtils.newStringUtf8(Base64.encodeBase64(file.getBytes()));
        List<String> images = new ArrayList<>(Collections.emptyList());
        images.add(base64);
        FacialSetupDTO facialSetupDTO = new FacialSetupDTO(null, images);
        RecognitionResult recognitionResult = FacialRecognitionUtil.prepareVerifyRequest(facialSetupDTO);
        Optional<Student> studentOptional = studentRepository.findById(Long.parseLong(recognitionResult.getPartId()));
        if (!studentOptional.isPresent()) throw new EntityNotFoundException("Student", Long.parseLong(recognitionResult.getPartId()));
        clockService.create(Long.parseLong(recognitionResult.getPartId()), (int) recognitionResult.getProbability());
        return studentOptional.get().getName();
    }
}
