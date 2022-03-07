package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Schedule { //class which describes a schedule (list of links)
    List<Link> assignment = new ArrayList<Link>(); //the list to store links
    int number; //number of links

    public Schedule() { //constructor
        number = 0;
    }

    void newAssignment(Link l) { //used to push a new assignment to the schedule
        boolean assignmentExists = false;
        for (int index = 0; index < number; index++) {
            assignmentExists = l.equals(assignment.get(index));
            if (assignmentExists) {
                System.out.println("Attention: Assignment [" + l.toString() + "] exists!\nNew assignment ignored.");
                break;
            }
        }

        if (!assignmentExists) {
            assignment.add(l);
            number++;
        }

    }

    @Override
    public String toString() { //returns the schedule in a string form
        String output = "";
        for (int index = 0; index < number; index++) {
            output += (index + 1) + ": " + assignment.get(index).toString();
            output += "\n";
        }
        return output;
    }
}
