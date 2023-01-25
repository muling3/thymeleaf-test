package com.muling3.thymeleaf.svc;

import com.muling3.thymeleaf.entity.Employee;
import com.muling3.thymeleaf.repo.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffService {

    @Autowired
    private StaffRepository repo;

    //save an employee
    public String addAnEmployee(Employee employee){
        repo.save(employee);
        return "Saved successfully";
    }

    //get all employees
    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }

    //get a single employee
    public Employee getEmployee(int id){
        return repo.findById(id).get();
    }

    //update an employee
    public String updateEmployee(int id, Employee employee){
        Employee emp = repo.findById(id).get();
        emp.setStaffNo(employee.getStaffNo());
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setGender(employee.getGender());
        emp.setJobType(employee.getJobType());
        repo.save(emp);

        return "Updated successfully";
    }

    //delete an employee
    public String deleteEmployee(int id){
        repo.deleteById(id);
        return "Deleted Successfully";
    }

    public int getFemaleEmployees(){
        return repo.findAll().stream().filter(employee -> employee.getGender().equals("Female")).collect(Collectors.toList()).size();
    }
    public int getMaleEmployees(){
        return repo.findAll().stream().filter(employee -> employee.getGender().equals("Male")).collect(Collectors.toList()).size();
    }

}
