package im;

import java.util.*;
import java.io.*;

public class SWEA_8658_Summation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 10개의 자연수가 차례대로 주어짐
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int min = Integer.MAX_VALUE,max=Integer.MIN_VALUE;
			while (st.hasMoreTokens()) {
				int sum = 0;
				char[] arr = st.nextToken().toCharArray();
				
				for (char ch : arr) sum += Character.getNumericValue(ch);
				min = Math.min(min, sum);
				max = Math.max(max, sum);
			}
			
			System.out.println("#"+t+" "+max+" "+min);
		}
	}

}
