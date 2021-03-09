package dbfs;

import java.util.*;
public class Programmers_BDFS_Set {
	private int[] ans;
    public int[] solution(int n, int s) {
        if (n>s) return new int[] {-1};
        
    	ans = new int[n];
        Arrays.fill(ans, s/n);
        for (int i = 0; i < s%n; i++) ans[i]+=1;
        
        Arrays.sort(ans);
        for (int i:ans) System.out.print(i+" ");
        return ans;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Programmers_BDFS_Set().solution(8, 100);
	}

}
