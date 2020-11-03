package com.example.controller.fakecontrollers;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SpecialAgent {

    @NotNull
    private String name;
    private String surname;
    @Pattern(regexp = "[0-9]{1,3}", message = "Code must be 007 or similar")
    private String code;
    @NotBlank
    private String status;
    @Min(value = 18, message = "Age must be greater than or equal to 18")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
