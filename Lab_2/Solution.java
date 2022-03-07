package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Event> eventList = new ArrayList<Event>();
    List<Room> roomList = new ArrayList<Room>();


    public Solution() {
    }

    void feedEvent(Event event) {
        boolean instanceExists = false;
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

    void feedRoom(Room room){
        boolean instanceExists = false;
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

    Schedule giveSolution(){
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
