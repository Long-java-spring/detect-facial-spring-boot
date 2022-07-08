package com.iist.register.configurations;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSS3ClientConfiguration {

    @Value("${aws.s3-client.aws_access_key_id}")
    private String accessKeyId;

    @Value("${aws.s3-client.aws_secret_access_key}")
    private String secretAccessKey;

    @Value("${aws.s3-client.region}")
    private String region;

    @Value("${aws.s3-client.s3_bucket}")
    private String s3Bucket;

    @Value("${aws.s3-client.setup_bucket}")
    private String setupBucket;

    @Value("${aws.s3-client.verify_bucket}")
    private String verifyBucket;

    public AmazonS3 buildAmazonS3Client() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);

        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)
                .build();
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    public String getRegion() {
        return region;
    }

    public String getS3Bucket() {
        return s3Bucket;
    }

    public String getSetupBucket() {
        return setupBucket;
    }

    public String getVerifyBucket() {
        return verifyBucket;
    }
}
