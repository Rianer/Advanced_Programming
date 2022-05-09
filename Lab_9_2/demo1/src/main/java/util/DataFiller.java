package util;

import entities.Clients;
import entities.Companies;
import entities.Products;
import net.bytebuddy.utility.RandomString;
import repository.ClientsRepository;
import repository.CompaniesRepository;
import repository.ProductsRepository;

import java.util.Random;

public class DataFiller {
    private int numberOfData;

    public DataFiller(int numberOfData) {
        this.numberOfData = numberOfData;
    }

    public int getNumberOfData() {
        return numberOfData;
    }

    public void setNumberOfData(int numberOfData) {
        this.numberOfData = numberOfData;
    }

    public void fillData(){
        String clientName = "clientName";
        String companyName = "companyName";
        String productName = "productName";
        Random rand = new Random();
        int quantity;

        ClientsRepository clientsRepository = new ClientsRepository();
        CompaniesRepository companiesRepository = new CompaniesRepository();
        ProductsRepository productsRepository = new ProductsRepository();

        long startTime = System.nanoTime();
        for(int index = 0; index < numberOfData; index++){
            Clients client = new Clients();
            client.setName(clientName);

            Companies company = new Companies();
            company.setName(companyName);

            quantity = rand.nextInt(25);
            Products product = new Products();
            product.setName(productName);
            product.setQuantity(quantity);
            product.setReferencedClient(client);
            product.setReferencedCompany(company);

            clientsRepository.save(client);
            companiesRepository.save(company);
            productsRepository.save(product);

            System.out.println("Added: " + product.toString());
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        double elapsedTimeSeconds = (double) duration / 1_000_000_000;
        System.out.println("Execution time: " + elapsedTimeSeconds + " seconds");

    }
}
