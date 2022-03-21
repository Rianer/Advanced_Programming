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

    public List<LinkedList<Street>> joinStreets(List<Street> streetList){ //returns a list of linked streets
                                                                          // 2 streets are linked if they have a common intersection
        List<LinkedList<Street>> table = new ArrayList<LinkedList<Street>>(); //result table
        Set<Street> checked = new HashSet<Street>(); //used for checking
        LinkedList<Street> linked;
        Street studied;
        for(Street iterator : streetList){ //iterates through street list provided
            linked = new LinkedList<Street>(); //represents the list of linked streets
            for(int index = 0; index < 2; index++){ //checks both ends of each street
                if(!checked.contains(iterator)){
                    checked.add(iterator);
                    linked.add(iterator);
                    studied = iterator;

                    for(Street linkIterator : streetList){ //iterates through neighbour adjacent streets
                        if(linked.contains(linkIterator)) continue;
                        if(studied == iterator){
                            if(studied.getIntersections().get(index) == linkIterator.getIntersections().get(0) || //test for same joints
                                    studied.getIntersections().get(index) == linkIterator.getIntersections().get(1))
                            {
                                linked.add(linkIterator);
                                checked.add(linkIterator);
                                studied = linkIterator;
                            }
                        }
                        else{
                            if(studied.getIntersections().get(0) == linkIterator.getIntersections().get(0) || //test for same joints
                                    studied.getIntersections().get(0) == linkIterator.getIntersections().get(1) ||
                               studied.getIntersections().get(1) == linkIterator.getIntersections().get(0) ||
                                     studied.getIntersections().get(1) == linkIterator.getIntersections().get(1))
                            {
                                linked.add(linkIterator);
                                studied = linkIterator;
                            }
                        }
                    }
                }
            }
            if(linked.size()>1){ //if more than one street is linked then a new list is added
                table.add(linked);
            }
        }

        return table;
    }

    public void showStreetsLongerThan(int length) {
        List<Street> filteredList = streetList.stream().filter(e -> e.getLength() >= length).toList();
        System.out.println("Streets longer than " + length + "km :");
        filteredList.forEach(System.out::println);
        System.out.println("Joined streets:");
        List<LinkedList<Street>> table = joinStreets(filteredList);
        for(LinkedList<Street> rowIterator : table){
            System.out.print("Linked streets: ");
            for(Street iterator : rowIterator){
                System.out.print(iterator.getName() + ", ");
            }
            System.out.println(';');
        }
    }
}
