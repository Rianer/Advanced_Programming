package entities;

import javax.persistence.*;

@Entity
public class Products {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "quantity")
    private int quantity;
    @Basic
    @Column(name = "id_company", insertable = false, updatable = false, nullable = true)
    private Integer idCompany;
    @Basic
    @Column(name = "id_client", insertable = false, updatable = false, nullable = true)
    private Integer idClient;
    @ManyToOne
    @JoinColumn(name = "id_company", referencedColumnName = "id", nullable = true)
    private Companies referencedCompany;
    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = true)
    private Clients referencedClient;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        if (id != products.id) return false;
        if (quantity != products.quantity) return false;
        if (idCompany != products.idCompany) return false;
        if (idClient != products.idClient) return false;
        if (name != null ? !name.equals(products.name) : products.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + idCompany;
        result = 31 * result + idClient;
        return result;
    }

    public Companies getReferencedCompany() {
        return referencedCompany;
    }

    public void setReferencedCompany(Companies referencedCompany) {
        this.referencedCompany = referencedCompany;
    }

    public Clients getReferencedClient() {
        return referencedClient;
    }

    public void setReferencedClient(Clients referencedClient) {
        this.referencedClient = referencedClient;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", idCompany=" + idCompany +
                ", idClient=" + idClient +
                ", referencedCompany=" + referencedCompany +
                ", referencedClient=" + referencedClient +
                '}';
    }
}
