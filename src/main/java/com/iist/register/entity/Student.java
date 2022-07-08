package com.iist.register.entity;

import com.iist.register.dto.StudentDTO;
import com.iist.register.enums.Gender;
import com.iist.register.shared.DateUtil;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "address")
    private String address;

    @Column(name = "class_id")
    private Long classId;

    @Column(name = "facial_recognition_status")
    private Boolean facialRecognitionStatus;

    public Student() {
    }

    public Student(StudentDTO studentDTO) {
        name = studentDTO.getName();
        gender = studentDTO.getGender();
        birthday = DateUtil.formatToDate(studentDTO.getBirthday());
        address = studentDTO.getAddress();
        classId = studentDTO.getClassId();
        facialRecognitionStatus = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Boolean getFacialRecognitionStatus() {
        return facialRecognitionStatus;
    }

    public void setFacialRecognitionStatus(Boolean facialRecognitionStatus) {
        this.facialRecognitionStatus = facialRecognitionStatus;
    }
}
