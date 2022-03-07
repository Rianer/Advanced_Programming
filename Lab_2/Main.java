package com.company;

public class Main {

    public static void main(String[] args) {
        //declaring 5 events
        Event course1 = new Event(8, 10, 100, "C1");
        Event course2 = new Event(10, 12, 100, "C2");
        Event course3 = new Event(10, 12, 100, "C2");
        Event lecture1 = new Event(8, 10, 30, "L1");
        Event lecture2 = new Event(8, 10, 30, "L2");
        Event lecture3 = new Event(10, 12, 30, "L3");

        //declaring 4 rooms
        Room room401 = new ComputerLab("R401", 30, "Linux");
        Room room403 = new ComputerLab("R403", 30);
        Room room405 = new ComputerLab("R405", 30, "Windows 10");
        Room room309 = new LectureHall("R309", 100);
        Room room306 = new LectureHall("R306", 100, true);

        //examples of object printing
        /*System.out.println(room309.toString());
        System.out.println(lecture2.toString());
        System.out.println(room405.getRoomName());
        System.out.println(room401.toString());
        System.out.println(room306.toString());*/

        //linking events to specified rooms
        /*Link link1 = new Link(course1, room309);
        Link link2 = new Link(course2, room309);
        Link link3 = new Link(lecture1, room401);
        Link link4 = new Link(lecture2, room403);
        Link link5 = new Link(lecture3, room401);*/

        //printing the linkage
        /*System.out.println(link1.toString());
        System.out.println(link2.toString());
        System.out.println(link3.toString());
        System.out.println(link4.toString());
        System.out.println(link5.toString());*/

        System.out.println(course2.equals(course3));


        Schedule schedule = new Schedule();
        /*schedule.newAssignment(link1);
        schedule.newAssignment(link2);
        schedule.newAssignment(link3);
        schedule.newAssignment(link3);
        schedule.newAssignment(link4);
        schedule.newAssignment(link5);
        System.out.println(schedule.toString());*/

        Solution solution = new Solution();

        solution.feedEvent(lecture1);
        solution.feedEvent(lecture2);
        solution.feedEvent(lecture3);
        solution.feedEvent(course1);
        solution.feedEvent(course2);
        solution.feedEvent(course3);

        solution.feedRoom(room306);
        solution.feedRoom(room309);
        solution.feedRoom(room401);
        solution.feedRoom(room403);
        solution.feedRoom(room405);

        schedule = solution.giveSolution();

        System.out.println(schedule.toString());

    }
}
