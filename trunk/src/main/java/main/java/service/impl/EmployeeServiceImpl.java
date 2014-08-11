package main.java.service.impl;

import java.util.List;

import main.java.dao.IEmployeeDAO;
import main.java.model.Company;
import main.java.model.Employee;
import main.java.service.IEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
    @Autowired
    private IEmployeeDAO employeeDAO;
    
    @Transactional
    public void addEmployee(Employee employee) {
    	employeeDAO.addEmployee(employee);
    }
    
    @Transactional
    public List<Employee> listEmployee() {
        return employeeDAO.listEmployee();
    }
    
    @Transactional
    public void removeEmployee(Integer id) {
    	employeeDAO.removeEmployee(id);
    }

    @Transactional
	public List<Employee> listEmployeeForCompany(Company c) {
    	return employeeDAO.listEmployeeForCompany(c);
	}
    
}
