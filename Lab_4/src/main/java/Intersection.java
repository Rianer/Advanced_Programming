import com.github.javafaker.Faker;
public class Intersection {
    String name;

    public Intersection(String name) {
        this.name = name;
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
}
