package service;

import model.Company;
import model.Sector;

import java.util.List;

public interface CompanyService {
    Company create(String name, Sector sector);
    void deleteById(String id);
    List<Company> getAll();
}
