import com.github.javafaker.Faker;
public class Intersection {
    String name;
    int numberOfStreets;

    public Intersection(String name) {
        this.name = name;
        numberOfStreets = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void generateFakeName(){
        Faker faker = new Faker();
        String name = faker.address().lastName();
        setName(name);
    }

    public void newStreet(){
        this.numberOfStreets++;
    }

    public int getNumberOfStreets(){
        return numberOfStreets;
    }
}
