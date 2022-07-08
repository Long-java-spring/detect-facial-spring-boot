package com.iist.register.controller;

import com.iist.register.dto.FacialSetupDTO;
import com.iist.register.enums.FacialRecognitionType;
import com.iist.register.service.RecognitionService;
import com.iist.register.shared.S3Util;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facial-recognitions")
public class RecognitionController {

    private final RecognitionService recognitionService;

    public RecognitionController(RecognitionService recognitionService) {
        this.recognitionService = recognitionService;
    }

    @PostMapping("/setup")
    public ResponseEntity<Void> registerFacialRecognition(@RequestBody FacialSetupDTO facialSetupDTO) {
        recognitionService.register(facialSetupDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/train")
    public ResponseEntity<Void> registerFacialRecognition() {
        recognitionService.train();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/verify")
    public ResponseEntity<String> VerifyFacialRecognition(@RequestBody FacialSetupDTO facialSetupDTO) throws Exception {
        return ResponseEntity.ok(recognitionService.verify(facialSetupDTO));
    }

    @GetMapping("/setup/get-image")
    public HttpEntity<byte[]> getSetupImage(@RequestParam String imagePath) {
        byte[] result = new S3Util().getImageFromS3ServerByPath(imagePath, FacialRecognitionType.SETUP);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(result.length);
        return new HttpEntity<>(result, headers);
    }

    @GetMapping("/verify/get-image")
    public HttpEntity<byte[]> getVerifyImage(@RequestParam String imagePath) {
        byte[] result = new S3Util().getImageFromS3ServerByPath(imagePath, FacialRecognitionType.VERIFY);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(result.length);
        return new HttpEntity<>(result, headers);
    }
}
