package service.impl;

import model.Company;
import model.Sector;
import repository.CompanyRepository;
import service.CompanyService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company create(String name, Sector sector) {
        Company company = new Company(name, sector);
        companyRepository.save(company);
        return company;
    }

    @Override
    public void deleteById(String id) {
        companyRepository.deleteById(id);
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.getAll();
    }

}
