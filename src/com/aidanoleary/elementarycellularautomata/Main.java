package com.aidanoleary.elementarycellularautomata;

import com.aidanoleary.elementarycellularautomata.displays.ConsoleDisplay;
import com.aidanoleary.elementarycellularautomata.displays.GraphicalDisplay;
import com.aidanoleary.elementarycellularautomata.displays.IDisplay;
import com.aidanoleary.elementarycellularautomata.rules.IRuleStrategy;
import com.aidanoleary.elementarycellularautomata.rules.Rule222;
import com.aidanoleary.elementarycellularautomata.rules.Rule250;
import com.aidanoleary.elementarycellularautomata.rules.Rule30;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int[] initialState = new int[100];
        initialState[initialState.length / 2] = 1;

        IRuleStrategy rule = new Rule30();
        //IDisplay display = new ConsoleDisplay();

        GraphicalDisplay display = new GraphicalDisplay();
        initJFrame(display, initialState.length * 100, initialState.length * 100);

        CellularAutomata cellularAutomata = new CellularAutomata(initialState, 50, rule);
        cellularAutomata.registerDisplay(display);
        cellularAutomata.Run();
    }

    private static void initJFrame(JPanel display, int width, int height) {
        JFrame frame = new JFrame("Cellular Automata");
        frame.getContentPane().add(display);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }


}
