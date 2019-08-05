package com.aidanoleary.elementarycellularautomata.rules;

public class Rule222 implements IRuleStrategy {
    @Override
    public int getNextCellState(int left, int mid, int right) {
            int outputCell = 0;

            if(left == 1 && mid == 1 && right == 1)
                outputCell = 1;
            else if(left == 1 && mid == 1 && right == 0)
                outputCell = 1;
            else if(left == 1 && mid == 0 && right == 1)
                outputCell = 1;
            else if(left == 1 && mid == 0 && right == 0)
                outputCell = 1;
            else if(left == 0 && mid == 1 && right == 1)
                outputCell = 1;
            else if(left == 0 && mid == 1 && right == 0)
                outputCell = 1;
            else if(left == 0 && mid == 0 && right == 1)
                outputCell = 1;
            else if(left == 0 && mid == 0 && right == 0)
                outputCell = 0;

            return outputCell;
    }
}
