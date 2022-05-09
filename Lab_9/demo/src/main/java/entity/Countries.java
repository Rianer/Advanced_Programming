package entity;

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
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "id_continent", insertable = false, updatable = false, nullable = true)
    private Integer idContinent;
    @ManyToOne
    @JoinColumn(name = "id_continent", referencedColumnName = "id")
    private Continents referencedContinent;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getIdContinent() {
        return idContinent;
    }

    public void setIdContinent(Integer idContinent) {
        this.idContinent = idContinent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Countries countries = (Countries) o;

        if (id != countries.id) return false;
        if (name != null ? !name.equals(countries.name) : countries.name != null) return false;
        if (code != null ? !code.equals(countries.code) : countries.code != null) return false;
        if (idContinent != null ? !idContinent.equals(countries.idContinent) : countries.idContinent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (idContinent != null ? idContinent.hashCode() : 0);
        return result;
    }

    public Continents getReferencedContinent() {
        return referencedContinent;
    }

    public void setReferencedContinent(Continents referencedContinent) {
        this.referencedContinent = referencedContinent;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", idContinent=" + idContinent +
                ", continentsByIdContinent=" + referencedContinent +
                '}';
    }
}
