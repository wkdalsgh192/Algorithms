package im;

import java.util.Arrays;
import java.util.Scanner;

public class Dwarf {

	private static boolean flag;
	private static int[] input, output;
	private static boolean[] used;
	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		input = new int[9];
		for (int i = 0; i < 9; i++) {
			input[i] = sc.nextInt();
		}
		
		output = new int[7];
		used = new boolean[9];
		Combination(0,0);
		
		for (int d : output) System.out.println(d);
		
		sc.close();
	}
	
	private static void Combination(int cnt, int start) {

		if (cnt == 7) {
			int sum = 0;
			for(int d : output) sum += d;
			if (sum == 100) {
				Arrays.sort(output);
				flag = true;
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			if (flag) break;
			if (used[i]) continue;
			output[cnt] = input[i];
			used[i] = true;
			Combination(cnt+1, i+1);
			used[i] = false;
			
		}
	}
	
	public static void main(String[] args) {
		new Dwarf().Solution();

	}

}
