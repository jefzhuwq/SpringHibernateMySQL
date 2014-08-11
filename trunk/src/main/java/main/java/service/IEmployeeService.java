package main.java.service;

import java.util.List;

import main.java.model.Company;
import main.java.model.Employee;

public interface IEmployeeService {
	
    public void addEmployee (Employee employee);
    public List<Employee> listEmployee();
    public List<Employee> listEmployeeForCompany(Company c);
    public void removeEmployee(Integer id);
    
}
