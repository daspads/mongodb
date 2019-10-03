package com.app.model;


import com.app.controller.EmployeeDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Document(collection = "employee")
public class Employee {

    @Id
    private String id;

    @Indexed(unique = true)
    @Field(value = "code")
    private String code;

    @Field(value = "name")
    private String name;

    @Field(value = "cognome")
    private String cognome;

    @Field(value = "birth_date")
    private Date birth_date;

    @Field(value = "salary")
    private double salary;

    //costructor

    public Employee(){}

    public Employee(EmployeeDTO employeeDTO){
        this.name=employeeDTO.getName();
        this.code=employeeDTO.getCode();
        this.birth_date=Date.from(employeeDTO.getBirth_date().atStartOfDay(ZoneId.of(("Europe,Rome"))).toInstant());
    }

    public Employee(String id, String name, String cognome, Date birth_date, double salary) {
        this.id = id;
        this.name = name;
        this.cognome = cognome;
        this.birth_date = birth_date;
        this.salary = salary;
    }

    //getter and setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", cognome='" + cognome + '\'' +
                ", birth_date=" + birth_date +
                ", salary=" + salary +
                '}';
    }
}
