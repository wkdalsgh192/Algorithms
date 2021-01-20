package dp;

import java.util.Scanner;

public class CoinSum {

	private static int N, res[], arr[];
	private void Solution() {
	    Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
	    
	    arr = new int[N+1];
	    for (int i = 1; i <= N; i++) {
	    	arr[i] = sc.nextInt();
	    }
	    
	   int max = arr[1];
	   for (int i = 2; i <= N; i++) {
		   
		   // 조건을 둬서 최대값을 만들어낸다. 
		   if (arr[i-1] > 0) arr[i] += arr[i-1];
		   
		   if (max < arr[i]) max = arr[i];
		   
		   for (int k : arr) System.out.print(k+" ");
		   System.out.println();
	   }
	   
	   System.out.println(max);
	    
	}
	public static void main(String[] args) {
	    new CoinSum().Solution();
	}
}
