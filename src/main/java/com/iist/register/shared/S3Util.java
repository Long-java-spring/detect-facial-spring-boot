package com.iist.register.shared;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.iist.register.configurations.AWSS3ClientConfiguration;
import com.iist.register.enums.FacialRecognitionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class S3Util {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public byte[] getImageFromS3ServerByPath(String imagePath, FacialRecognitionType type) {
        AWSS3ClientConfiguration config = new AWSS3ClientConfiguration();
        AmazonS3 s3Client = new AWSS3ClientConfiguration().buildAmazonS3Client();
        if (!s3Client.doesBucketExistV2(config.getS3Bucket())) {
            logger.error("ERROR_getImagesFromS3ServerForClockEvent: Bucket name does not exist on s3 server");
            return new byte[0];
        }

        String imageDir = config.getSetupBucket();
        if (type == FacialRecognitionType.VERIFY) imageDir = config.getVerifyBucket();

        byte[] result = new byte[0];
        try {
            S3Object s3Object = s3Client.getObject(config.getS3Bucket() + "/" + imageDir, imagePath);
            S3ObjectInputStream s3is = s3Object.getObjectContent();

            result = IOUtils.toByteArray(s3is);
            s3is.close();
        } catch (AmazonServiceException e) {
            logger.error("getImageFromS3ServerByPath: {}", e.getErrorMessage());
        } catch (IOException e) {
            logger.error("getImageFromS3ServerByPath: {}", e.getMessage());
        }
        return result;
    }
}
