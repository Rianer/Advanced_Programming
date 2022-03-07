package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Network myNetwork = new Network();
        Node node1 = new Computer("Computer A");
        Node node2 = new Router("Router A");
        Node node3 = new Switch("Switch A");
        Node node4 = new Computer("Computer B");
        Node node5 = new Router("Router B");
        Node node6 = new Switch("Switch B");

        myNetwork.addNode(node1);
        myNetwork.addNode(node2);
        myNetwork.addNode(node3);
        myNetwork.addNode(node4);
        myNetwork.addNode(node5);
        myNetwork.addNode(node6);

        System.out.println(myNetwork.toString());
    }
}
