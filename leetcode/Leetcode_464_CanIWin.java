package leetcode;

import java.util.*;

public class Leetcode_464_CanIWin {
    // public boolean canIWin(int mCI, int dT) {

    // if (dT <= mCI)
    // return true;
    // boolean[] dp = new boolean[dT + 1];
    // for (int i = 0; i <= mCI; i++)
    // dp[i] = true;

    // int N = (dT - (mCI + 1)) / mCI;
    // Arrays.fill(dp, true);
    // for (int i = 0; i <= N; i++)
    // dp[(i + 1) * mCI + 1] = false;

    // return dp[dT];

    // }
    public static boolean canIWin(int maxChooseableInt, int desiredTotal) {

        if (maxChooseableInt >= desiredTotal)
            return true;

        int sum = maxChooseableInt * (maxChooseableInt + 1) / 2;
        if (sum < desiredTotal) {
            return false;
        }

        HashMap<Integer, Boolean> memo = new HashMap<>();
        return canPlayerWin(maxChooseableInt, desiredTotal, 0, memo);

    }

    private static boolean canPlayerWin(int maxChooseableInt, int desiredTotal, int chosenState,
            HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(chosenState)) {
            return memo.get(chosenState);
        }

        for (int i = 0; i < maxChooseableInt; i++) {
            int curr = (1 << i);
            boolean isCurrChosen = (curr & chosenState) != 0;
            if (!isCurrChosen) {
                int newChosenState = curr | chosenState;
                if (desiredTotal <= i + 1
                        || !canPlayerWin(maxChooseableInt, desiredTotal - (i + 1), newChosenState, memo)) {
                    memo.put(chosenState, true);
                    return true;
                }
            }
        }
        memo.put(chosenState, false);
        return false;
    }
}
