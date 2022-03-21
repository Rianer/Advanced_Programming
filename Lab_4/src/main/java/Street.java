import java.util.ArrayList;
import java.util.List;
import com.github.javafaker.Faker;

public class Street {
    String name;
    int length;
    ArrayList<Intersection> link;

    public Street(String name, int length) {
        this.name = name;
        this.length = length;
        this.link = new ArrayList<Intersection>();
    }

    public Street(String name, int length, ArrayList<Intersection> link) {
        this.name = name;
        this.length = length;
        this.link = new ArrayList<Intersection>(link);
    }

    public Street(String name, int length, Intersection o1, Intersection o2) {
        this.name = name;
        this.length = length;
        this.link = new ArrayList<Intersection>();
        link.add(o1);
        link.add(o2);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void makeLink(Intersection o1, Intersection o2){
        if(link.size() >= 1){
            System.out.println("Street can not link another 2 intersections!");
        }
        else{
            link.add(o1);
            link.add(o2);
        }
    }

    public ArrayList<Intersection> getIntersections(){
        return link;
    }

    void generateFakeName(){
        Faker faker = new Faker();
        String streetAddress = faker.address().streetName();
        setName(streetAddress);
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", intersections= (" + this.getIntersections().get(0).getName() +
                ", " + this.getIntersections().get(1).getName() +
                ") }";
    }
}
