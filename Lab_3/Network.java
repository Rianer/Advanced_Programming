package com.company;

import java.util.ArrayList;
import java.util.List;

public class Network {//describes a Network
    ArrayList<Node> nodeList = new ArrayList<Node>(); //list of all nodes

    public Network(ArrayList<Node> nodeList) {//Constructor
        this.nodeList = nodeList;
    }

    public Network() {//Empty Constructor
    }

    void addNode(Node node){//add a Node to the list
        nodeList.add(node);
    }

    void getNode(int index){//get the Node at index position from the list
        nodeList.get(index);
    }

    //Convert the list to string
    @Override
    public String toString() {
        return "Network{" +
                "nodeList=" + nodeList +
                '}';
    }
}
