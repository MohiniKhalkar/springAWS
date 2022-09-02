package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {
    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    public Employee signUp(Employee employee){
        return employeeDaoImpl.signUp(employee);
    }
    public boolean signIn(String empEmailId, String empPassword) {
        return employeeDaoImpl.signIn(empEmailId,empPassword);
    }
    public List<Employee> getAllData() {

        return employeeDaoImpl.getAllData();
    }
    public void deleteData(int empId){

        employeeDaoImpl.deleteData(empId);
    }
    public  void  deleteAllData(){
        employeeDaoImpl.deleteAllData();
    }

}
