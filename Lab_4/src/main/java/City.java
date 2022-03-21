import org.jgrapht.Graph;
import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.*;
import java.util.stream.Stream;


public class City {
    LinkedList<Street> streetList;
    Set<Intersection> intersectionHashSet;

    public City(LinkedList<Street> streetList, Set<Intersection> intersectionHashSet) {
        this.streetList = streetList;
        this.intersectionHashSet = intersectionHashSet;
    }

    public void addStreet(Street street) {
        streetList.add(street);
    }

    public void addIntersection(Intersection intersection) {
        intersectionHashSet.add(intersection);
    }

    public void showStreetsLongerThan(int length) {
        List<Street> filteredList = streetList.stream().filter(e -> e.getLength() >= length).filter(e->e.getConnectionNumber()>3).toList();
        System.out.println("Streets longer than " + length + "km, which connect more than 3 streets :");
        filteredList.forEach(System.out::println);
    }
}
