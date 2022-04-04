package com.example.gamelab6;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;

public class Position {

    private Pane canvas;
    private Grid gameGrid;
    public int x;
    public int y;
    public int owner; //0 - none, 1 - RED, 2 - BLUE

    public Position(int x, int y, int owner, Pane canvas) {
        this.x = x;
        this.y = y;
        this.owner = owner;
        this.canvas = canvas;
    }

    public Position(Pane canvas) {
        this.x = 0;
        this.y = 0;
        this.owner = 0;
        this.canvas = canvas;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public Pane getCanvas() {
        return canvas;
    }

    public void setCanvas(Pane canvas) {
        this.canvas = canvas;
    }

    public Grid getGameGrid() {
        return gameGrid;
    }

    public void setGameGrid(Grid gameGrid) {
        this.gameGrid = gameGrid;
    }

    public void drawPosition(int radius){
        if(owner == 0){
            Arc arc = new Arc(x, y, radius, radius, 0, 360);
            arc.setFill(Color.TRANSPARENT);
            arc.setStroke(Color.BLACK);
            arc.addEventHandler(MouseEvent.MOUSE_PRESSED,
                    new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                            if(gameGrid.getCurrentPlayer() == 1){
                                gameGrid.setCurrentPlayer(2);
                                Circle circle = new Circle(radius, Color.RED);
                                circle.setCenterX(x); circle.setCenterY(y);
                                canvas.getChildren().add(circle);
                            }
                            else{
                                gameGrid.setCurrentPlayer(1);
                                Circle circle = new Circle(radius, Color.BLUE);
                                circle.setCenterX(x); circle.setCenterY(y);
                                canvas.getChildren().add(circle);
                            }
                        }
                    });
            canvas.getChildren().add(arc);
        }
        else if(owner == 1){
            Circle circle = new Circle(radius, Color.RED);
            circle.setCenterX(x); circle.setCenterY(y);
            canvas.getChildren().add(circle);
        }
        else if(owner == 2){
            Circle circle = new Circle(radius, Color.BLUE);
            circle.setCenterX(x); circle.setCenterY(y);
            canvas.getChildren().add(circle);
        }
    }
}
