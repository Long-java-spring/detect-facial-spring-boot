package com.iist.register.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iist.register.enums.Gender;

import java.time.LocalDate;

public class StudentDTO {

    @JsonProperty
    private Long studentId;

    @JsonProperty
    private String name;

    @JsonProperty
    private Gender gender;

    @JsonProperty
    private LocalDate birthday;

    @JsonProperty
    private String address;

    @JsonProperty
    private Boolean facialRecognitionStatus;

    @JsonProperty
    private Long classId;

    public StudentDTO() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getFacialRecognitionStatus() {
        return facialRecognitionStatus;
    }

    public void setFacialRecognitionStatus(Boolean facialRecognitionStatus) {
        this.facialRecognitionStatus = facialRecognitionStatus;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }
}
