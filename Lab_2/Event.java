package com.company;

public class Event { //class which defines an Event
    int startTime; //the time when the event starts
    int endTime; //the time when the event ends
    int size; //the size of the audience
    String eventName; //event's name, if not specified it is set to "Unknown"

    public Event(int startTime, int endTime, int size) { //constructor without specifying the name
        this.startTime = startTime;
        this.endTime = endTime;
        this.size = size;
        this.eventName = "Unknown";
    }

    public Event(int startTime, int endTime, int size, String name) { //constructor with the name specified
        this.startTime = startTime;
        this.endTime = endTime;
        this.size = size;
        this.eventName = name;
    }

    //Getters and Setters for all the components
    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getSize() {
        return size;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public String toString() { //used for printing Event's properties
        return "Event{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", size=" + size +
                ", eventName='" + eventName + '\'' +
                '}';
    }
}

