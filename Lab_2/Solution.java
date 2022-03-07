package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Event> eventList = new ArrayList<Event>(); //list of given events
    List<Room> roomList = new ArrayList<Room>(); //list of given rooms


    public Solution() {
    }

    void feedEvent(Event event) { //push an event to the list of events
        boolean instanceExists = false;
        //Checks if the provided event is unique
        for (int index = 0; index < eventList.size(); index++) {
            instanceExists = event.equals(eventList.get(index));
            if (instanceExists) {
                System.out.println("Attention: Event [" +
                        event.getEventName() + "] already exists!\n");
                break;
            }
        }
        if (!instanceExists) {
            eventList.add(event);
        }
    }

    void feedRoom(Room room){ //push a room to the list of rooms
        boolean instanceExists = false;
        //Checks if the provided room is unique
        for (int index = 0; index < roomList.size(); index++) {
            instanceExists = room.equals(roomList.get(index));
            if (instanceExists) {
                System.out.println("Attention: Event [" +
                        room.getRoomName() + "] already exists!\n");
                break;
            }
        }
        if (!instanceExists) {
            roomList.add(room);
        }
    }

    Schedule giveSolution(){ //calculate the solution and returns it as a Schedule
        Schedule schedule = new Schedule();
        int bestRoom = 0;
        List<Integer> freeTime = new ArrayList<Integer>();
        for(int index = 0; index < roomList.size(); index++){
            freeTime.add(0);
        }
        for(int index = 0; index < eventList.size(); index++) {
            for (int index2 = 0; index2 < roomList.size(); index2++) {
                if(roomList.get(index2).getCap() >= eventList.get(index).getSize()){
                    if(freeTime.get(index2) <= eventList.get(index).getStartTime() && freeTime.get(index2) < freeTime.get(bestRoom)){
                        bestRoom = index2;
                    }
                }
            }
            Link auxLink = new Link(eventList.get(index),roomList.get(bestRoom));
            schedule.newAssignment(auxLink);
            freeTime.set(bestRoom, eventList.get(index).getEndTime());
        }

        return schedule;
    }


}
