package com.example.gamelab6;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;

public class GridRow {
    private Pane canvas;
    private int rowLength;
    private List<Line> lineList;
    private Coordinates rowStart;
    private Coordinates lastLineStart;
    private int lineLength;

    public GridRow(Pane canvas, int rowLength, Coordinates rowStart, int lineLength) {
        this.canvas = canvas;
        lineList = new ArrayList<>();
        this.rowLength = rowLength;
        this.rowStart = rowStart;
        this.lineLength = lineLength;
        this.lastLineStart = new Coordinates(rowStart.getX(), rowStart.getY());
    }

    public GridRow(Pane canvas) {
        this.canvas = canvas;
        lineList = new ArrayList<>();
        this.lineLength = 0;
        this.rowStart = new Coordinates(0, 0);
        this.rowLength = 0;
        this.lastLineStart = new Coordinates(0, 0);
    }

    public int getRowLength() {
        return rowLength;
    }

    public void setRowLength(int rowLength) {
        this.rowLength = rowLength;
    }

    public Coordinates getRowStart() {
        return rowStart;
    }

    public void setRowStart(Coordinates rowStart) {
        this.rowStart = rowStart;
    }

    public int getLineLength() {
        return lineLength;
    }

    public void setLineLength(int lineLength) {
        this.lineLength = lineLength;
    }

    public void drawRow(){

        while(lineList.size() < rowLength - 1){
            Line newLine = new Line(lastLineStart.getX(), lastLineStart.getY(), lastLineStart.getX()+lineLength, lastLineStart.getY());
            lineList.add(newLine);
            canvas.getChildren().add(newLine);
            lastLineStart.increaseX(lineLength);
        }
    }

    public void drawRow(int startX, int startY){

        while(lineList.size() < rowLength - 1){
            Line newLine = new Line(startX, startY, startX+lineLength, startY);

            lineList.add(newLine);
            canvas.getChildren().add(newLine);
            startX += lineLength;
        }
    }

    public void drawRow(int startX, int startY, List<Integer> status){
        int index = 0;
        while(lineList.size() < rowLength - 1){
            Line newLine = new Line(startX, startY, startX+lineLength, startY);
            if(status.get(index) == 1) {
                newLine.setStrokeWidth(3);
            }
            else {
                newLine.setStrokeWidth(1);
                newLine.setStroke(Color.GRAY);
            }
            lineList.add(newLine);
            canvas.getChildren().add(newLine);
            startX += lineLength;
            index++;
        }
    }

    public void drawConnectionsUp(){
        Coordinates lastNode = new Coordinates(rowStart.getX(), rowStart.getY());
        for(int currentNode = 0 ; currentNode < rowLength; currentNode++){
            Line connectionLine = new Line(lastNode.getX(), lastNode.getY(), lastNode.getX(), lastNode.getY()-lineLength);
            canvas.getChildren().add(connectionLine);
            lastNode.increaseX(lineLength);
        }
    }

    public void drawColumn(int startX, int startY, int columns, List<List<Integer>> status){
        int index = 0;
        for(int iterator = 0; iterator < rowLength - 1; iterator++){
            while(lineList.size() < columns - 1){
                Line newLine = new Line(startX, startY, startX, startY+lineLength);
                if(status.get(iterator).get(index) == 1) {
                    newLine.setStrokeWidth(3);
                }
                else {
                    newLine.setStrokeWidth(1);
                    newLine.setStroke(Color.GRAY);
                }
                lineList.add(newLine);
                canvas.getChildren().add(newLine);
                startY += lineLength;
                index++;
            }
            startX += lineLength;
        }

    }
}
