package main.java.service.impl;

import java.util.List;

import main.java.dao.ICompanyDAO;
import main.java.model.Company;
import main.java.service.ICompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyServiceImpl implements ICompanyService {
	
    @Autowired
    private ICompanyDAO companyDAO;
    
    @Transactional
    public void addCompany(Company company) {
    	companyDAO.addCompany(company);
    }
    
    @Transactional
    public List<Company> listCompany() {
        return companyDAO.listCompany();
    }
    
    @Transactional
    public void removeCompany(Integer id) {
    	companyDAO.removeCompany(id);
    }
    
}
