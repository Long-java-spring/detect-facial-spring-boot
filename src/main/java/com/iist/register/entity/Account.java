package com.iist.register.entity;

import com.iist.register.dto.AccountDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "organization_name")
    private String organizationName;
    @Column(name = "in_late_threshold")
    private Integer inLateThreshold;
    @Column(name = "out_early_threshold")
    private Integer outEarlyThreshold;

    public Account() {
    }

    public Account(AccountDTO userDTO) {
        this.username = userDTO.getUsername();
        this.password = new BCryptPasswordEncoder().encode(userDTO.getPassword());
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.address = userDTO.getAddress();
        this.organizationName = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Integer getInLateThreshold() {
        return inLateThreshold;
    }

    public void setInLateThreshold(Integer inLateThreshold) {
        this.inLateThreshold = inLateThreshold;
    }

    public Integer getOutEarlyThreshold() {
        return outEarlyThreshold;
    }

    public void setOutEarlyThreshold(Integer outEarlyThreshold) {
        this.outEarlyThreshold = outEarlyThreshold;
    }
}
