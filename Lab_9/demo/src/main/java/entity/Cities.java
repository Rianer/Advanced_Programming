package entity;

import javax.persistence.*;

@Entity
public class Cities {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "longitude")
    private String longitude;
    @Basic
    @Column(name = "latitude")
    private String latitude;
    @Basic
    @Column(name = "id_country", insertable = false, updatable = false, nullable = true)
    private Integer idCountry;
    @ManyToOne
    @JoinColumn(name = "id_country", referencedColumnName = "id")
    private Countries referencedCountry;

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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cities cities = (Cities) o;

        if (id != cities.id) return false;
        if (name != null ? !name.equals(cities.name) : cities.name != null) return false;
        if (longitude != null ? !longitude.equals(cities.longitude) : cities.longitude != null) return false;
        if (latitude != null ? !latitude.equals(cities.latitude) : cities.latitude != null) return false;
        if (idCountry != null ? !idCountry.equals(cities.idCountry) : cities.idCountry != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (idCountry != null ? idCountry.hashCode() : 0);
        return result;
    }

    public Countries getReferencedCountry() {
        return referencedCountry;
    }

    public void setReferencedCountry(Countries referencedCountry) {
        this.referencedCountry = referencedCountry;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", idCountry=" + idCountry +
                ", countriesByIdCountry=" + referencedCountry +
                '}';
    }
}
