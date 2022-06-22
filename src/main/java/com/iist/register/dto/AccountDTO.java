package com.iist.register.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDTO {
    @JsonProperty
    private long userId;

    @JsonProperty
    private String username;
    @JsonProperty
    private String password;

    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String address;

    @JsonProperty
    private String organizationName;

    @JsonProperty
    private Integer inLateThreshold;

    @JsonProperty
    private Integer outEarlyThreshold;

    public AccountDTO() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
