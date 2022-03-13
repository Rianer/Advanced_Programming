package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Network myNetwork = new Network();
        Computer node1 = new Computer("Computer A", "v1", "00:01:5e:30:63:ce");
        Router node2 = new Router("Router A", "v2", "00:00:5e:00:53:af");
        Switch node3 = new Switch("Switch A", "v3");
        Switch node4 = new Switch("Switch B", "v4", "00:00:5e:00:53:af");
        Router node5 = new Router("Router B", "v5");
        Computer node6 = new Computer("Computer B", "v6");

        node1.setStorage(13.5);
        node2.setIp("127.0.0.1");

        myNetwork.addNode(node1);
        myNetwork.addNode(node2);
        myNetwork.addNode(node3);
        myNetwork.addNode(node4);
        myNetwork.addNode(node5);
        myNetwork.addNode(node6);

        myNetwork.setNodeCost("v1","v2",10);
        myNetwork.setNodeCost("v1","v3",50);
        myNetwork.setNodeCost("v3","v1",50);
        myNetwork.setNodeCost("v2","v3",20);
        myNetwork.setNodeCost("v2","v4",20);
        myNetwork.setNodeCost("v2","v5",10);
        myNetwork.setNodeCost("v3","v4",20);
        myNetwork.setNodeCost("v4","v5",30);
        myNetwork.setNodeCost("v4","v6",10);
        myNetwork.setNodeCost("v5","v6",20);

        System.out.println(myNetwork);
        System.out.println(node1.getStorageMb());
        System.out.println(myNetwork.showCostMap());
        System.out.println(myNetwork.showIdentifiable());
    }
}
