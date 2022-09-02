package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

@PostMapping("/signup")
    public ResponseEntity<Employee>signUp(@RequestBody Employee employee){
   log.info("sign up successfully");
    return ResponseEntity.ok(employeeServiceImpl.signUp(employee));
}
    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public  ResponseEntity  signIn(@PathVariable String empEmailId, String empPassword){
        return  ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId,empPassword));
    }
    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>>getAllData(){

    return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }
    @DeleteMapping("/deletedatabyid/{empId}")
    public ResponseEntity<String>deleteDataById(@PathVariable int empId){
        employeeServiceImpl.deleteData(empId);
        return ResponseEntity.ok("delete data successfully");
    }
    @DeleteMapping("/deletealldata")
    public ResponseEntity<String>deleteAllData() {
        employeeServiceImpl.deleteAllData();
        return ResponseEntity.ok("delete all data");


    }
}
