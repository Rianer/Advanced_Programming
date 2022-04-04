package com.example.gamelab6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.controlsfx.control.action.Action;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private int columns;
    private int rows;
    private int circleRadius;

    @FXML
    private Pane canvas;

    @FXML
    private Spinner<Integer> widthValue;

    @FXML
    private Spinner<Integer> heightValue;

    public void load(ActionEvent actionEvent) {
        System.out.println("Loading...");
    }

    public void save(ActionEvent actionEvent) {
        System.out.println("Saving...");
        GridRow row = new GridRow(canvas, columns, new Coordinates(10,10),15);
        row.drawRow();
    }

    public void insertCircle(ActionEvent actionEvent) {
        canvas.getChildren().clear();
        circleRadius = 10;
        this.columns = heightValue.getValue();
        this.rows = widthValue.getValue();
        int lastCircleX = circleRadius;
        int lastCircleY = circleRadius;

        Grid gameGrid = new Grid(canvas, rows, columns, circleRadius*4);
        gameGrid.computeGrid(10,10, circleRadius);
        gameGrid.drawGrid();


        for (int index = 0; index < this.rows; index++) {
            for (int rowIndex = 0; rowIndex < this.columns; rowIndex++) {
                Position obj = new Position(lastCircleX, lastCircleY, 0, canvas);
                obj.setGameGrid(gameGrid);
                obj.drawPosition(circleRadius);
                lastCircleX += circleRadius * 4;
            }
            lastCircleX = circleRadius;
            lastCircleY += circleRadius * 4;
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> valueFactoryW = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 10);
        valueFactoryW.setValue(8);
        widthValue.setValueFactory(valueFactoryW);

        SpinnerValueFactory<Integer> valueFactoryH = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 10);
        valueFactoryH.setValue(8);
        heightValue.setValueFactory(valueFactoryH);
    }
}