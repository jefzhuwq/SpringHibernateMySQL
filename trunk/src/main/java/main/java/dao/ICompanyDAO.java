package main.java.dao;

import java.util.List;

import main.java.model.Company;

public interface ICompanyDAO {

    public void addCompany (Company company);
    public List<Company> listCompany();
    public void removeCompany (Integer id);
    
}
