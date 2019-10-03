package com.app.controller;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class EmployeeDTO {
    private String code;
    private String name;
    @DateTimeFormat( iso = DateTimeFormat.ISO.DATE)
    private LocalDate birth_date;

    public EmployeeDTO(String code, String name, LocalDate birth_date) {
        this.code = code;
        this.name = name;
        this.birth_date = birth_date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }
}
