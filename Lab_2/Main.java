package com.company;

public class Main {

    public static void main(String[] args) {
        //declaring 5 events
        Event course1 = new Event(8, 10, 100, "C1");
        Event course2 = new Event(10, 12, 100, "C2");
        Event lecture1 = new Event(8, 10, 30, "L1");
        Event lecture2 = new Event(8, 10, 30, "L2");
        Event lecture3 = new Event(10, 12, 30, "L3");

        //declaring 4 rooms
        Room room401 = new Room(RoomType.COMPUTER_LAB, 30, "R401");
        Room room403 = new Room(RoomType.COMPUTER_LAB, 30, "R403");
        Room room405 = new Room(RoomType.COMPUTER_LAB, 30, "R405");
        Room r309 = new Room(RoomType.LECTURE_HALL, 100, "R309");

        //examples of object printing
        System.out.println(r309.toString());
        System.out.println(lecture2.toString());
        System.out.println(room405.getRoomName());

        //linking events to specified rooms
        Link link1 = new Link(course1, r309);
        Link link2 = new Link(course2, r309);
        Link link3 = new Link(lecture1, room401);
        Link link4 = new Link(lecture2, room403);
        Link link5 = new Link(lecture3, room401);

        //printing the linkage
        System.out.println(link1.toString());
        System.out.println(link2.toString());
        System.out.println(link3.toString());
        System.out.println(link4.toString());
        System.out.println(link5.toString());
    }
}
