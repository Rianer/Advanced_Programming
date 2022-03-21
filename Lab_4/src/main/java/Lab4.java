import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Lab4 {
    public static void main(String[] args){
        Stream<Intersection> streamBuilder = Stream.<Intersection>builder().add(new Intersection("Int_A"))
                .add(new Intersection("Int_B")).add(new Intersection("Int_C"))
                .add(new Intersection("Int_D")).add(new Intersection("Int_E"))
                .add(new Intersection("Int_F")).add(new Intersection("Int_G"))
                .add(new Intersection("Int_H")).add(new Intersection("Int_I")).build();


        ArrayList<Intersection> intersectionsList = new ArrayList<Intersection>(streamBuilder.toList());
        intersectionsList.stream().forEach(Intersection::generateFakeName);

        Street street1 = new Street("Street One", 2, intersectionsList.get(0), intersectionsList.get(1));
        Street street2 = new Street("Street Two", 2, intersectionsList.get(0), intersectionsList.get(2));
        Street street3 = new Street("Street Three", 2, intersectionsList.get(0), intersectionsList.get(3));
        Street street4 = new Street("Street Four", 3, intersectionsList.get(1), intersectionsList.get(4));
        Street street5 = new Street("Street Five", 2, intersectionsList.get(1), intersectionsList.get(2));
        Street street6 = new Street("Street Six", 2, intersectionsList.get(2), intersectionsList.get(6));
        Street street7 = new Street("Street Seven", 2, intersectionsList.get(2), intersectionsList.get(5));
        Street street8 = new Street("Street Eight", 1, intersectionsList.get(2), intersectionsList.get(3));
        Street street9 = new Street("Street Nine", 3, intersectionsList.get(3), intersectionsList.get(5));
        Street street10 = new Street("Street Ten", 1, intersectionsList.get(4), intersectionsList.get(7));
        Street street11 = new Street("Street Eleven", 2, intersectionsList.get(4), intersectionsList.get(8));
        Street street12 = new Street("Street Twelve", 1, intersectionsList.get(4), intersectionsList.get(5));
        Street street13 = new Street("Street Thirteen", 3, intersectionsList.get(5), intersectionsList.get(8));
        Street street14 = new Street("Street Fourteen", 1, intersectionsList.get(6), intersectionsList.get(7));
        Street street15 = new Street("Street Fifteen", 1, intersectionsList.get(6), intersectionsList.get(8));
        Street street16 = new Street("Street Sixteen", 1, intersectionsList.get(7), intersectionsList.get(8));

        LinkedList<Street> streetsList = new LinkedList<Street>(Arrays.asList(street1, street2, street3, street4, street5, street6, street7,
                                         street8, street9, street10, street11, street12, street13, street14, street15, street16));
        
        streetsList.stream().forEach(Street::generateFakeName);

        streetsList.sort(new Comparator<Street>() {
            @Override
            public int compare(Street o1, Street o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        Set<Intersection> intersectionSet = new HashSet<Intersection>(intersectionsList);

        City myCity = new City(streetsList, intersectionSet);

        myCity.showStreetsLongerThan(2);
    }
}
