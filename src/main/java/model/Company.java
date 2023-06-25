package model;

public class Company extends BaseModel{
    private String name;
    private Sector sector;

    public Company(String name, Sector sector) {
        this.name = name;
        this.sector = sector;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", name='" + name + '\'' +
                ", sector=" + sector +
                "} " + super.toString();
    }
}
