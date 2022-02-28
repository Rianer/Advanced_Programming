package com.company;

public class Link { //class which defines a link between a room and an event
    Event event; //the event to be assigned to a room
    Room room; //the room to host an event

    public Link(Event event, Room room) { //constructor
        this.event = event;
        this.room = room;
    }

    @Override
    public String toString() { //used for printing the linkage
        return event.getEventName() + " --> " + room.getRoomName();
    }
}
