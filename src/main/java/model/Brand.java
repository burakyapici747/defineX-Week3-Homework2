package model;

public class Brand extends BaseModel{
    private String name;
    private Company company;

    public Brand(String name, Company company){
        this.name = name;
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", name='" + name + '\'' +
                ", company=" + company +
                "} " + super.toString();
    }
}
