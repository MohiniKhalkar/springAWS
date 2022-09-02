package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDaoImpl {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee signUp(Employee employee){
        return employeeRepository.save(employee);
    }
    public boolean signIn(String empEmailId, String empPassword) {
        boolean flag=false;

        for(Employee employee:employeeRepository.findAll()) {
            if(employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {
                flag=true;
            }
        }

        return flag;
    }
    public List<Employee> getAllData() {

        return employeeRepository.findAll();
    }
    public void deleteData(int empId){

        employeeRepository.deleteById(empId);
    }
    public  void  deleteAllData(){
        employeeRepository.deleteAll();
    }

}
