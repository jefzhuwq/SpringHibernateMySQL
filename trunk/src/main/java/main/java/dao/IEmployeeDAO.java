package main.java.dao;

import java.util.List;

import main.java.model.Company;
import main.java.model.Employee;

public interface IEmployeeDAO {

    public void addEmployee (Employee employee);
    public List<Employee> listEmployee();
	public List<Employee> listEmployeeForCompany(Company c);
    public void removeEmployee (Integer id);
    
}
