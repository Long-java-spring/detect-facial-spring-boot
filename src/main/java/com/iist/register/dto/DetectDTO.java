package com.iist.register.dto;

import java.util.List;

public class DetectDTO {
    private Long userId;
    private String userName;
    private List<String> images;

    public DetectDTO() {
    }

    public DetectDTO(Long userId, String userName, List<String> images) {
        this.userId = userId;
        this.userName = userName;
        this.images = images;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
