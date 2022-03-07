package com.company;

import java.util.ArrayList;
import java.util.List;

public class Network {
    ArrayList<Node> nodeList = new ArrayList<Node>();

    public Network(ArrayList<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public Network() {
    }

    void addNode(Node node){
        nodeList.add(node);
    }

    void getNode(int index){
        nodeList.get(index);
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodeList=" + nodeList +
                '}';
    }
}
