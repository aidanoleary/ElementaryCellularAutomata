package com.aidanoleary.elementarycellularautomata.displays;

import com.aidanoleary.elementarycellularautomata.CellularAutomata;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphicalDisplay extends JPanel implements IDisplay {

    private ArrayList<int[]> _cellularAutomataStates;

    private final int SQUARE_SIZE = 10;


    @Override
    public void displayState(CellularAutomata subject) {
        _cellularAutomataStates = subject.getPreviousStates();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        for(int i = 0; i < _cellularAutomataStates.size(); i++) {
            for(int j = 1; j < _cellularAutomataStates.get(i).length - 1; j++) {
                if(_cellularAutomataStates.get(i)[j] == 1)
                    g.setColor(Color.BLACK);
                else
                    g.setColor(Color.WHITE);

                g.fillRect(j * SQUARE_SIZE + 75, i * SQUARE_SIZE + 10, SQUARE_SIZE / 2, SQUARE_SIZE / 2);
            }
        }
    }
}
