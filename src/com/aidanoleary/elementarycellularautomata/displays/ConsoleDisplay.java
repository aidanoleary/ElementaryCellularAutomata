package com.aidanoleary.elementarycellularautomata.displays;

import com.aidanoleary.elementarycellularautomata.CellularAutomata;

public class ConsoleDisplay implements IDisplay {

    @Override
    public void displayState( CellularAutomata subject) {
        for(int i : subject.getCurrentState()) {
            if(i == 0)
                System.out.print("[ ] ");
            if(i == 1)
                System.out.print("[*] ");
        }
        System.out.println();
    }
}
