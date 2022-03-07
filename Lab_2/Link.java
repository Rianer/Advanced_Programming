package com.company;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return event.equals(link.event) && room.equals(link.room);
    }
}
