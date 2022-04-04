package com.example.gamelab6;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Grid {
    private List<GridRow> grid;
    private int currentPlayer = 1;
    private Pane canvas;
    private int rows;
    private int columns;
    private int lineLength;
    private Coordinates startCoordinates;
    public List<List<Integer>> horizontalConection = new ArrayList<>();
    public List<List<Integer>> verticalConection = new ArrayList<>();
    public List<List<Position>> stones = new ArrayList<>();

    public Grid(List<GridRow> grid, Pane canvas, int rows, int columns, int lineLength, Coordinates startCoordinates) {
        this.grid = grid;
        this.canvas = canvas;
        this.rows = rows;
        this.columns = columns;
        this.lineLength = lineLength;
        this.startCoordinates = startCoordinates;
    }

    public Grid(Pane canvas, int rows, int columns, int lineLength) {
        this.grid = new ArrayList<>();
        this.canvas = canvas;
        this.rows = rows;
        this.columns = columns;
        this.lineLength = lineLength;
        this.startCoordinates = new Coordinates(0, 0);
    }

    public Pane getCanvas() {
        return canvas;
    }

    public void setCanvas(Pane canvas) {
        this.canvas = canvas;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public List<GridRow> getGrid() {
        return grid;
    }

    public void setGrid(List<GridRow> grid) {
        this.grid = grid;
    }

    public int getLineLength() {
        return lineLength;
    }

    public void setLineLength(int lineLength) {
        this.lineLength = lineLength;
    }

    public Coordinates getStartCoordinates() {
        return startCoordinates;
    }

    public void setStartCoordinates(Coordinates startCoordinates) {
        this.startCoordinates = startCoordinates;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void drawGrid() {
        int rowIndex = 0;
        for (GridRow iterator : grid){
            iterator.drawRow(iterator.getRowStart().getX(), iterator.getRowStart().getY(), horizontalConection.get(rowIndex));
            rowIndex++;
        }

        int yOffset = 0;
        for (Position stone : stones.get(0)){
            int hIndex = 0;
            yOffset = 0;
            for(int vIndex = 0; vIndex < rows-1; vIndex++){
                Line newLine = new Line(stone.x, stone.y + yOffset, stone.x, stone.y + yOffset + lineLength);
                if(verticalConection.get(vIndex).get(hIndex) == 1){
                    newLine.setStrokeWidth(3);
                }
                else{
                    newLine.setStrokeWidth(1);
                    newLine.setStroke(Color.GRAY);
                }
                canvas.getChildren().add(newLine);
                yOffset += lineLength;
            }
            hIndex++;
        }
    }

    public void computeGrid(int startX, int startY, int circleRadius) {

        Random rand = new Random();

        for (int currentRow = 0; currentRow < rows; currentRow++) {

            GridRow newRow = new GridRow(canvas);
            newRow.setRowLength(columns);
            newRow.setLineLength(lineLength);
            newRow.setRowStart(new Coordinates(startCoordinates.getX() + startX, startCoordinates.getY() + startY + lineLength * currentRow));
            grid.add(newRow);

            List<Integer> status = new ArrayList<>();
            for (int index = 0; index < columns - 1; index++){
                status.add(rand.nextInt(2));
            }
            horizontalConection.add(status);
        }

        for (int currentColumn = 0; currentColumn < columns; currentColumn++){
            List<Integer> status = new ArrayList<>();
            for (int index = 0; index < rows - 1; index++){
                status.add(rand.nextInt(2));
            }
            verticalConection.add(status);
        }

        int lastCircleX = startX;
        int lastCircleY = startY;

        for (int index = 0; index < rows; index++) {
            List<Position> row = new ArrayList<>();
            for (int rowIndex = 0; rowIndex < columns; rowIndex++) {
                Position obj = new Position(lastCircleX, lastCircleY, 0, canvas);
                row.add(obj);
                lastCircleX += circleRadius * 4;
            }
            stones.add(row);
            lastCircleX = circleRadius;
            lastCircleY += circleRadius * 4;
        }
    }
}
