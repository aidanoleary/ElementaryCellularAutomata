package com.aidanoleary.elementarycellularautomata;

import com.aidanoleary.elementarycellularautomata.displays.IDisplay;
import com.aidanoleary.elementarycellularautomata.rules.IRuleStrategy;
import java.util.ArrayList;

public class CellularAutomata {

    private final int SPEED_IN_MILLIS = 500;

    private int[] _initialState;
    private int[] _currentState;
    private final int _numberOfSteps;
    private IRuleStrategy _rule;

    private ArrayList<int[]> _previousStates;

    private ArrayList<IDisplay> _displayObservers;

    public CellularAutomata(int[] initialState, int numberOfSteps, IRuleStrategy rule) {
        _initialState = initialState;
        _numberOfSteps = numberOfSteps;
        _rule = rule;

        _displayObservers = new ArrayList<>();
    }

    public void Run() throws InterruptedException {
        _previousStates = new ArrayList<>();
        _currentState = _initialState;
        for(int i = 0; i < _numberOfSteps; i++) {
            displayState();
            storePreviousState();
            getNextState();
            Thread.sleep(SPEED_IN_MILLIS);
        }
    }

    private void storePreviousState() {
        _previousStates.add(_currentState);
    }

    private void getNextState() {
        int[] newState = new int[_currentState.length];

        for(int i = 1; i < _currentState.length - 1; i++) {
            int left = _currentState[i - 1];
            int mid = _currentState[i];
            int right = _currentState[i + 1];

            int nextCellState = _rule.getNextCellState(left, mid, right);
            newState[i] = nextCellState;
        }

        _currentState = newState;
    }

    public int[] getCurrentState() {
        return _currentState;
    }

    public ArrayList<int[]> getPreviousStates() {
        return _previousStates;
    }

    public void registerDisplay(IDisplay displayObserver) {
        _displayObservers.add(displayObserver);
    }

    public void removeObserver(IDisplay displayObserver) {
        _displayObservers.remove(displayObserver);
    }

    private void displayState() {
        for(IDisplay display : _displayObservers) {
            display.displayState(this);
        }
    }

}
