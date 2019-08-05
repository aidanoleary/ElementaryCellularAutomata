package com.aidanoleary.elementarycellularautomata;

import com.aidanoleary.elementarycellularautomata.displays.ConsoleDisplay;
import com.aidanoleary.elementarycellularautomata.displays.IDisplay;
import com.aidanoleary.elementarycellularautomata.rules.IRuleStrategy;
import com.aidanoleary.elementarycellularautomata.rules.Rule222;
import com.aidanoleary.elementarycellularautomata.rules.Rule250;
import com.aidanoleary.elementarycellularautomata.rules.Rule30;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int[] initialState = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        IRuleStrategy rule = new Rule250();
        IDisplay consoleDisplay = new ConsoleDisplay();

        CellularAutomata cellularAutomata = new CellularAutomata(initialState, 50, rule);
        cellularAutomata.registerDisplay(consoleDisplay);
        cellularAutomata.Run();
    }


}
