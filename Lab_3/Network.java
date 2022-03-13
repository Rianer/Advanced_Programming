package com.company;

import java.util.*;

public class Network {//describes a Network
    ArrayList<Node> nodeList = new ArrayList<Node>(); //list of all nodes

    public Network(ArrayList<Node> nodeList) {//Constructor
        this.nodeList = nodeList;
    }

    public Network() {//Empty Constructor
    }

    void addNode(Node node) {//add a Node to the list
        nodeList.add(node);
        Collections.sort(nodeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getNodeName().compareTo(o2.getNodeName());
            }
        });
    }

    void getNode(int index) {//get the Node at index position from the list
        nodeList.get(index);
    }

    Node getNodeByMapLocation(String mapLocation) {
        for (Node iterator : nodeList) {
            if (iterator.getMapLocation().compareTo(mapLocation) == 0) {
                return iterator;
            }
        }
        return null;
    }

    public void setNodeCost(String mapLocation1, String mapLocation2, int cost) {
        Node node1 = getNodeByMapLocation(mapLocation1);
        Node node2 = getNodeByMapLocation(mapLocation2);
        if (node1 == null) {
            System.out.println("Couldn't find a node on location " + mapLocation1 + '!');
        } else if (node2 == null) {
            System.out.println("Couldn't find a node on location " + mapLocation2 + '!');
        } else {
            node1.setNewCost(mapLocation2, cost);
            node2.setNewCost(mapLocation1, cost);
        }
    }

    public void setNodeCost(Node node1, Node node2, int cost) {
        node1.setNewCost(node2.getMapLocation(), cost);
        node2.setNewCost(node1.getMapLocation(), cost);
    }

    public String showCostMap(){
        String map = "";
        String startNodeLocation, mapNodeName, mirroredNodeName;
        ArrayList<String> mapNodes = new ArrayList<String>();
        for (Node iterator : nodeList) {
            startNodeLocation = iterator.getMapLocation();
            for (Map.Entry<String, Integer> e : iterator.costMap.entrySet()){
                mapNodeName = startNodeLocation + "-" + e.getKey();
                mirroredNodeName = e.getKey() + "-" + startNodeLocation;
                if(!mapNodes.contains(mapNodeName) && !mapNodes.contains(mirroredNodeName)){
                    mapNodes.add(mapNodeName);
                    map += mapNodeName + " = " + e.getValue() + '\n';
                }
            }
        }
        return map;
    }

    public String showIdentifiable(){
        ArrayList<Node> identifiableList = new ArrayList<Node>();
        String result = "Identifiable nodes:\n";
        for(Node iterator : nodeList){
            /*if(iterator.getClass().getInterfaces()[0].getSimpleName().compareTo("Identifiable") == 0){
                result += 'a';
            }*/
            for(int index = 0 ; index < iterator.getClass().getInterfaces().length; index++){
                if(iterator.getClass().getInterfaces()[index].getSimpleName().compareTo("Identifiable") == 0){
                    identifiableList.add(iterator);
                    break;
                }
            }
        }
        Collections.sort(identifiableList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1 instanceof Computer){
                    if(o2 instanceof Computer){
                        return ((Computer)o1).getIp().compareTo(((Computer)o2).getIp());
                    }
                    else{
                        return ((Computer)o1).getIp().compareTo(((Router)o2).getIp());
                    }
                }
                else{
                    if(o2 instanceof Computer){
                        return ((Router)o1).getIp().compareTo(((Computer)o2).getIp());
                    }
                    else{
                        return ((Router)o1).getIp().compareTo(((Router)o2).getIp());
                    }
                }
            }
        });

        for(Node iterator : identifiableList){
            result += iterator.toString();
        }

        return  result;
    }
    //Convert the list to string
    @Override
    public String toString() {
        return "Network{" +
                "nodeList=" + nodeList +
                '}';
    }
}
