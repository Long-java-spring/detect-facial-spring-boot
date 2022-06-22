package com.iist.register.entity;

import com.iist.register.dto.ClassDTO;

import javax.persistence.*;

@Entity
@Table(name = "classes")
public class Class {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "class_name")
    private String className;
    @Column(name = "total_students")
    private Integer totalStudents;
    @Column(name = "account_id")
    private Long accountId;

    public Class() {
    }

    public Class(ClassDTO dto) {
        className = dto.getClassName();
        totalStudents = dto.getTotalStudents();
        accountId = dto.getAccountId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(Integer totalStudents) {
        this.totalStudents = totalStudents;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
