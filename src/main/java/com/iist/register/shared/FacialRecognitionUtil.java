package com.iist.register.shared;

import com.google.gson.Gson;
import com.iist.register.dto.DetectDTO;
import com.iist.register.dto.FacialSetupDTO;
import com.iist.register.dto.RecognitionResult;
import com.iist.register.security.AuthTokenFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class FacialRecognitionUtil {

    private static final String facial_recognition_server="http://localhost:5000";
    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    public static void prepareRegisterRequest(FacialSetupDTO facialSetupDTO, String name) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            logger.info("Setting up user with ID {} for facial recognition", facialSetupDTO.getUserId());
            restTemplate.postForObject(facial_recognition_server + "/register",
                    new DetectDTO(facialSetupDTO.getUserId(), name, facialSetupDTO.getImages()),
                    String.class);
        } catch (Exception e) {
            logger.error("ERROR_FACIAL_RECOGNITION call API setup error: {}", e.getMessage());
            throw e;
        }
    }

    public static void prepareTrainRequest() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.postForObject(facial_recognition_server + "/train", null, String.class);
        } catch (Exception e) {
            logger.error("ERROR_FACIAL_RECOGNITION call API setup error: {}", e.getMessage());
            throw e;
        }
    }

    public static RecognitionResult prepareVerifyRequest(FacialSetupDTO facialSetupDTO) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(facial_recognition_server + "/verify",
                facialSetupDTO,
                String.class);
        if (result == null) throw new Exception("Invalid request");
        RecognitionResult image = new Gson().fromJson(result, RecognitionResult.class);
        if (image.getProbability() * 100 < 90) throw new Exception("Warning: Probability lower");
        return image;
    }
}
