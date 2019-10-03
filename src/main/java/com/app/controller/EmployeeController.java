package com.app.controller;

import com.app.model.Employee;
import com.app.repository.EmployeeRepository;
import com.app.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @RequestMapping("/")
    public String home() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='/nuovo'> Insert</a></li>";
        html += " <li><a href='/showAllEmployee'>Show All Employee</a></li>";
        html += " <li><a href='/showFullNameLikeTom'>Show All 'Tom'</a></li>";
        html += " <li><a href='/deleteAllEmployee'>Delete All Employee</a></li>";
        html += "</ul>";
        return html;
    }

    @ResponseBody
    @GetMapping(value = "/nuovo")
    public String addEmplyee(){
        String html="";
        html+="<form method='POST' action='/testInsert'>" +
                "<label>Codice</label>" +
                "<input type='text' name='code'>" +
                "<label>Nome</label>" +
                "<input type='text' name='name'>" +
                "<input type='date' name='birth_date'> "+
                "<input type='submit'/>" +
                "</form>";
        return html;
    }

    @ResponseBody()
    @PostMapping(value = "/testInsert")
    public String testInsert(@ModelAttribute @Valid EmployeeDTO employeeDTO){
        Employee employee= (Employee) employeeService.save(employeeDTO);
        return employeeDTO.toString();
    }
}
