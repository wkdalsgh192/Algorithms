package leetcode;

import java.util.*;
public class Leetcode_332_Coin {

	private static int total = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
//        for (int i=1;i<=amount;i++) recurse(amount, coins.length-1,coins,0);
        recurse(amount,coins.length-1,coins,0);
        return total == Integer.MAX_VALUE?-1:total;
    }
    private static void recurse(int num, int idx, int[] coins, int cnt) {
    	if (idx<0 || cnt>=total-1) return;
        
        int c = num/coins[idx];
        for (int i = c; i>=0; i--) {
        	int newCnt = cnt + i;
        	int rem = num - coins[idx]*i;
        	
        	if (rem>0 && newCnt<total) recurse(rem,idx-1,coins,newCnt); // 남은게 있고, 카운트가 최솟값보다 작은 경우
        	else if (newCnt<total) total = newCnt; // 남은게 0이하인 상태에서 카운트되었을 때
        	else if (newCnt>=total-1) break; // 카운트 갯수가 현재 최솟값보다 큰 경우
		}
    }
	public static void main(String[] args) {
		new Leetcode_332_Coin().coinChange(new int[] {186,419,83,408}, 6249);

	}

}
