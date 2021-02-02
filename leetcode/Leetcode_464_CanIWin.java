package leetcode;

import java.util.*;

public class Leetcode_464_CanIWin {
    public static boolean canIWin(int mci, int dt) {
        if (mci >= dt) return true;
        if (mci*(mci+1) / 2 < dt) return false;
        
        HashMap<Integer, Boolean> memo = new HashMap<>();
        return canPlayerWin(mci,dt,0,memo);
    }
    private static boolean canPlayerWin(int mci, int dt, int chosenState, HashMap<Integer,Boolean> memo) {
        if (memo.containsKey(chosenState)) return memo.get(chosenState);
        
        for (int i=0;i<mci;i++) {
            int curr = (1<<i);
            boolean isCurrChosen = (curr & chosenState) != 0;
            if (!isCurrChosen) {
                int newChosenState = curr | chosenState;
                if (dt <= i+1 || !canPlayerWin(mci, dt - (i+1), newChosenState, memo)) {
                    memo.put(chosenState, true);
                    return true;
                }
            }
        }

        memo.put(chosenState,false);
        return false;
    }
}
