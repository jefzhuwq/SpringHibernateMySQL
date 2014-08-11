package main.java.dao.impl;

import java.util.List;

import main.java.dao.IEmployeeDAO;
import main.java.model.Company;
import main.java.model.Employee;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {
	
    @Autowired
    private SessionFactory sessionFactory;
    
	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
	}
	
	public List<Employee> listEmployee() {
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}
	
	public List<Employee> listEmployeeForCompany(Company c) {
		return sessionFactory.getCurrentSession().createQuery("from Employee where id_company = :idCompany").setInteger("idCompany", c.getId()).list();
	}
	
	public void removeEmployee(Integer id) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, id);
        if (null != employee) {
            sessionFactory.getCurrentSession().delete(employee);
        }
	}
	
}
