package repository;

import entities.Clients;
import entities.Companies;
import entities.Products;
import entities.Products;
import util.DBAccess;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class ProductsRepository implements CrudRepository<Products> {

    private EntityManager em = DBAccess.getInstance();

    @Override
    public int count() {
        Query countQuery = em.createNativeQuery("SELECT count(*) FROM products");
        Object result = countQuery.getSingleResult();
        return ((BigInteger) result).intValue();
    }

    @Override
    public void deleteAll() {
        Query deleteQuery = em.createNativeQuery("DELETE from products ");
        deleteQuery.executeUpdate();
    }

    @Override
    public void deleteById(int id) {
        Query deleteQuery = em.createNativeQuery("DELETE from products where id = ?1");
        deleteQuery.setParameter(1,id);
        deleteQuery.executeUpdate();
    }

    @Override
    public boolean existsById(int id) {
        Query existsQuery = em.createNativeQuery("select count(*) FROM products WHERE id = ?1");
        existsQuery.setParameter(1,id);
        Object result = existsQuery.getSingleResult();
        if ( ((BigInteger) result).intValue() == 0){
            return false;
        }
        return true;
    }

    @Override
    public Iterable<Products> findAll() {

        //repositories used to access products and clients
        ClientsRepository clientsRepository = new ClientsRepository();
        CompaniesRepository companiesRepository = new CompaniesRepository();


        ArrayList<Products> resultList = new ArrayList<>();
        Query findQuerry = em.createNativeQuery("SELECT * FROM Products");

        List<Object> result = (List<Object>) findQuerry.getResultList();
        Iterator itr = result.iterator();
        while(itr.hasNext()){
            //iterating through query results
            Products product = new Products();
            Object[] obj = (Object[]) itr.next();
            Integer product_id = Integer.parseInt(String.valueOf(obj[0]));
            String product_name = String.valueOf(obj[1]);
            Integer product_quantity = Integer.parseInt(String.valueOf(obj[2]));

            //Checking if there is a company id
            Integer id_company;
            String query_id_company = String.valueOf(obj[3]);
            if(query_id_company.isEmpty() || query_id_company == "null"){
                id_company = -1;
            }
            else{
                id_company = Integer.parseInt(query_id_company);
            }

            //Checking if there is a client id
            Integer id_client;
            String query_id_client = String.valueOf(obj[4]);
            if(query_id_client.isEmpty() || query_id_client == "null"){
                id_client = -1;
            }
            else{
                id_client = Integer.parseInt(query_id_client);
            }
            //Getting the referenced client object
            Clients client = new Clients();
            Optional<Clients> clientObj = clientsRepository.findById(id_client);
            if(clientObj.isPresent() && id_client > 0 && clientsRepository.existsById(id_client)){
                client = clientObj.get();
            }
            else{
                client = null;
            }
            //Getting the referenced company object
            Companies company = new Companies();
            Optional<Companies> companyObj = companiesRepository.findById(id_company);
            if(companyObj.isPresent() && id_company > 0){
                company = companyObj.get();
            }
            else{
                company = null;
            }
            //Building the product object
            product.setId(product_id);
            product.setName(product_name);
            product.setQuantity(product_quantity);
            product.setIdCompany(id_company);
            product.setIdClient(id_client);
            product.setReferencedClient(client);
            product.setReferencedCompany(company);
            //Adding product to list
            resultList.add(product);
        }
        return resultList;
    }

    @Override
    public Optional<Products> findById(int id) {

        //repositories used to access products and clients
        ClientsRepository clientsRepository = new ClientsRepository();
        CompaniesRepository companiesRepository = new CompaniesRepository();

        Query findQuery = em.createNativeQuery("SELECT * FROM products WHERE id = ?1");
        findQuery.setParameter(1, id);

        List<Object> result = (List<Object>) findQuery.getResultList();
        Iterator itr = result.iterator();
        Products product = new Products();
        while(itr.hasNext()){
            //iterating through query results
            Object[] obj = (Object[]) itr.next();
            Integer product_id = Integer.parseInt(String.valueOf(obj[0]));
            String product_name = String.valueOf(obj[1]);
            Integer product_quantity = Integer.parseInt(String.valueOf(obj[2]));

            //Checking if there is a company id
            Integer id_company;
            String query_id_company = String.valueOf(obj[3]);
            if(query_id_company.isEmpty() || query_id_company == "null"){
                id_company = -1;
            }
            else{
                id_company = Integer.parseInt(query_id_company);
            }

            //Checking if there is a client id
            Integer id_client;
            String query_id_client = String.valueOf(obj[4]);
            if(query_id_client.isEmpty() || query_id_client == "null"){
                id_client = -1;
            }
            else{
                id_client = Integer.parseInt(query_id_company);
            }
            //Getting the referenced client object
            Clients client = new Clients();
            Optional<Clients> clientObj = clientsRepository.findById(id_client);
            if(clientObj.isPresent() && id_client > 0){
                client = clientObj.get();
            }
            else{
                client = null;
            }
            //Getting the referenced company object
            Companies company = new Companies();
            Optional<Companies> companyObj = companiesRepository.findById(id_company);
            if(companyObj.isPresent() && id_company > 0){
                company = companyObj.get();
            }
            else{
                company = null;
            }
            //Building the product object
            product.setId(product_id);
            product.setName(product_name);
            product.setQuantity(product_quantity);
            product.setIdCompany(id_company);
            product.setIdClient(id_client);
            product.setReferencedClient(client);
            product.setReferencedCompany(company);
        }
        return Optional.of(product);
    }

    @Override
    public void save(Products o) {
        em.persist(o);
    }
}
