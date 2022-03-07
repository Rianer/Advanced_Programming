package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Network myNetwork = new Network();
        Node node1 = new Computer("Computer A", "v1");
        Node node2 = new Router("Router A", "v2");
        Node node3 = new Switch("Switch A", "v3");
        Node node4 = new Computer("Switch B", "v4");
        Node node5 = new Router("Router B", "v5");
        Node node6 = new Switch("Computer B", "v6");

        myNetwork.addNode(node1);
        myNetwork.addNode(node2);
        myNetwork.addNode(node3);
        myNetwork.addNode(node4);
        myNetwork.addNode(node5);
        myNetwork.addNode(node6);

        System.out.println(myNetwork.toString());
    }
}
