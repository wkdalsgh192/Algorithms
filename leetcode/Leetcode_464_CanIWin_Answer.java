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
        // 한 번에 끝낼 수 있으면 바로 반환하기
        if (maxChooseableInt >= desiredTotal)
            return true;

        // 낼 수 있는 모든 수의 합보다 목표값이 더 크면 무조건 끝이다.
        int sum = maxChooseableInt * (maxChooseableInt + 1) / 2;
        if (sum < desiredTotal) {
            return false;
        }

        // 지금까지 사용한 숫자배열과 그 때의 값을 저장하는 해쉬맵을 만든다.
        HashMap<Integer, Boolean> memo = new HashMap<>();
        return canPlayerWin(maxChooseableInt, desiredTotal, 0, memo);

    }

    private static boolean canPlayerWin(int maxChooseableInt, int desiredTotal, int chosenState, HashMap<Integer, Boolean> memo) {
        // 이미 해당 숫자 배열에 대한 값이 있으면 재귀를 반복하지 않고 값을 반환한다.
        if (memo.containsKey(chosenState)) {
            return memo.get(chosenState);
        }

        for (int i = 0; i < maxChooseableInt; i++) {
            int curr = (1 << i);
            boolean isCurrChosen = (curr & chosenState) != 0; // curr & chosenState이 1이면 이미 사용했다는 뜻
            if (!isCurrChosen) { // 사용하지 않았으면
                int newChosenState = curr | chosenState; // 사용했다는 표시를 해놓고
                // 현재 플레이어가 이기는 상황이 있는 지 계산한다.
                // // 현재 내려는 수가 목표값보다 크거나 상대방이 이기지 않는다면
                if (desiredTotal <= i + 1 
                        || !canPlayerWin(maxChooseableInt, desiredTotal - (i + 1), newChosenState, memo)) { 
                    memo.put(chosenState, true); // 현재 플레이어는 이긴다.
                    return true;
                }
            }
        }
        // 루프를 도는 모든 경우에 이기는 수가 없다면 현재 플레이어는 진다.
        memo.put(chosenState, false);
        return false;
    }
}
