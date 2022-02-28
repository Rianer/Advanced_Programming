package com.company;

public class Main {

    public static void main(String[] args) {
        //declaring 5 events
        Event c1 = new Event(8, 10, 100, "C1");
        Event c2 = new Event(10, 12, 100, "C2");
        Event l1 = new Event(8, 10, 30, "L1");
        Event l2 = new Event(8, 10, 30, "L2");
        Event l3 = new Event(10, 12, 30, "L3");

        //declaring 4 rooms
        Room r401 = new Room(RoomType.COMPUTER_LAB, 30, "R401");
        Room r403 = new Room(RoomType.COMPUTER_LAB, 30, "R403");
        Room r405 = new Room(RoomType.COMPUTER_LAB, 30, "R405");
        Room r309 = new Room(RoomType.LECTURE_HALL, 100, "R309");

        //examples of object printing
        System.out.println(r309.toString());
        System.out.println(l2.toString());

        //linking events to specified rooms
        Link link1 = new Link(c1, r309);
        Link link2 = new Link(c2, r309);
        Link link3 = new Link(l1, r401);
        Link link4 = new Link(l2, r403);
        Link link5 = new Link(l3, r401);

        //printing the linkage
        System.out.println(link1.toString());
        System.out.println(link2.toString());
        System.out.println(link3.toString());
        System.out.println(link4.toString());
        System.out.println(link5.toString());
    }
}
