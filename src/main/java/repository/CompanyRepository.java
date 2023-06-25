package repository;

import model.Company;

import java.util.*;

public class CompanyRepository {
    private Map<UUID, Company> companies = new HashMap<>();

    public void save(Company company){
        companies.put(company.getId(), company);
    }

    public void deleteById(String id){
        companies.remove(UUID.fromString(id));
    }

    public List<Company> getAll(){
        return new ArrayList<>(companies.values());
    }
}
