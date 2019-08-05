package com.aidanoleary.elementarycellularautomata.rules;

public interface IRuleStrategy {
    int getNextCellState(int left, int mid, int right);
}
