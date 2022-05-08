package entities;

import javax.persistence.*;

@Entity
public class Countries {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "continent")
    private String continent;
    @Basic
    @Column(name = "code")
    private String code;

    public Countries() {
    }

    public Countries(int id, String name, String continent, String code) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Countries countries = (Countries) o;

        if (id != countries.id) return false;
        if (name != null ? !name.equals(countries.name) : countries.name != null) return false;
        if (continent != null ? !continent.equals(countries.continent) : countries.continent != null) return false;
        if (code != null ? !code.equals(countries.code) : countries.code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (continent != null ? continent.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
