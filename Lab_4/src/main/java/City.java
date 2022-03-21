import java.util.*;
import java.util.stream.Stream;

public class City {
    LinkedList<Street> streetList;
    Set<Intersection> intersectionHashSet;

    public City(LinkedList<Street> streetList, Set<Intersection> intersectionHashSet) {
        this.streetList = streetList;
        this.intersectionHashSet = intersectionHashSet;
    }

    public City() {
    }

    public void addStreet(Street street) {
        streetList.add(street);
    }

    public void addIntersection(Intersection intersection) {
        intersectionHashSet.add(intersection);
    }

    public List<Street> joinStreets(List<Street> streetList) {
        Map<Intersection, Integer> availableIntersections = new HashMap<Intersection, Integer>();
        Intersection mostVisitedIntersection = streetList.get(0).getIntersections().get(0);
        int maxInstances = 1;
        for (Street iterator : streetList) { //getting all available junctions from the list of streets
            for (int index = 0; index < 2; index++) {
                if (availableIntersections.containsKey(iterator.getIntersections().get(index))) { //if junction is already in set then increment instances

                    int instaces = availableIntersections.get(iterator.getIntersections().get(index)) + 1;
                    availableIntersections.put(iterator.getIntersections().get(index), instaces);

                    if (instaces > maxInstances) { //checking for maximum visited junctions
                        mostVisitedIntersection = iterator.getIntersections().get(index);
                        maxInstances = instaces;
                    }
                } else { //junction not in set; add junction
                    availableIntersections.put(iterator.getIntersections().get(index), 1);
                }
            }
        }

        List<Street> joinedStreets = new LinkedList<Street>();
        for(Street iterator : streetList){
            if(iterator.getIntersections().get(0) == mostVisitedIntersection || iterator.getIntersections().get(1) == mostVisitedIntersection){
                joinedStreets.add(iterator);
            }
        }
        return joinedStreets;
    }

    public void showStreetsLongerThan(int length) {
        List<Street> filteredList = streetList.stream().filter(e -> e.getLength() >= length).toList();
        System.out.println("Streets longer than " + length + "km :");
        filteredList.forEach(System.out::println);
        System.out.println("Joined streets:");
        joinStreets(filteredList).stream().forEach(System.out::println);
    }
}
