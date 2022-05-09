package util;

import entity.Cities;
import entity.Continents;
import entity.Countries;
import repository.CitiesRepository;

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
        String countryName = "Sample Name";
        String continentName = "Continent";
        String cityName = "NY City";
        String countryCode = "SN";
        String longitude = "39.906667";
        String latitude = "116.3975";

        CitiesRepository cr = new CitiesRepository();

        long startTime = System.nanoTime();
        for(int index = 0; index < numberOfData; index++){
            Continents continent = new Continents();
            continent.setName(continentName);

            Countries country = new Countries();
            country.setName(countryName);
            country.setCode(countryCode);
            country.setReferencedContinent(continent);

            Cities city = new Cities();
            city.setName(cityName);
            city.setLatitude(latitude);
            city.setLongitude(longitude);
            city.setReferencedCountry(country);

            cr.save(city);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        double elapsedTimeSeconds = (double) duration / 1_000_000_000;
        System.out.println("Execution time: " + elapsedTimeSeconds + " seconds");
    }
}
