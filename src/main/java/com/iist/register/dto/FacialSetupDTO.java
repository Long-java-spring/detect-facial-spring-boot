package com.iist.register.dto;

import java.util.List;

public class FacialSetupDTO {
    private Long userId;
    private List<String> images;

    public FacialSetupDTO(Long userId, List<String> images) {
        this.userId = userId;
        this.images = images;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
