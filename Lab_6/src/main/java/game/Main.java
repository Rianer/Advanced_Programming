package game;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame f=new JFrame();
        JButton createButton = new JButton("Create");
        JTextField wDimension = new JTextField();
        JTextField hDimension = new JTextField();
        JLabel label1 = new JLabel("Dimensions:");
        JButton upArrow = new BasicArrowButton(BasicArrowButton.NORTH);
        JButton downArrow = new BasicArrowButton(BasicArrowButton.SOUTH);

        JButton upArrow2 = new BasicArrowButton(BasicArrowButton.NORTH);
        JButton downArrow2 = new BasicArrowButton(BasicArrowButton.SOUTH);

        

        label1.setBounds(20,10,100,20);
        wDimension.setBounds(140, 10, 25, 20);
        upArrow.setBounds(165,10,25,10);
        downArrow.setBounds(165,20,25,10);

        hDimension.setBounds(210, 10, 25, 20);
        upArrow2.setBounds(235,10,25,10);
        downArrow2.setBounds(235,20,25,10);

        createButton.setBounds(280, 10, 90, 20);

        f.add(label1);
        f.add(wDimension);
        f.add(upArrow);
        f.add(downArrow);
        f.add(hDimension);
        f.add(upArrow2);
        f.add(downArrow2);
        f.add(createButton);

        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
    }
}
