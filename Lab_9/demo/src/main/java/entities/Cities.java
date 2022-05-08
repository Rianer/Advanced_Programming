package entities;

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
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "longitude")
    private String longitude;
    @Basic
    @Column(name = "latitude")
    private String latitude;
    @Basic
    @Column(name = "capital")
    private Boolean capital;

    public Cities() {
    }

    public Cities(int id, String name, String country, String longitude, String latitude, Boolean capital) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
        this.capital = capital;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cities cities = (Cities) o;

        if (id != cities.id) return false;
        if (name != null ? !name.equals(cities.name) : cities.name != null) return false;
        if (country != null ? !country.equals(cities.country) : cities.country != null) return false;
        if (longitude != null ? !longitude.equals(cities.longitude) : cities.longitude != null) return false;
        if (latitude != null ? !latitude.equals(cities.latitude) : cities.latitude != null) return false;
        if (capital != null ? !capital.equals(cities.capital) : cities.capital != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        return result;
    }
}
