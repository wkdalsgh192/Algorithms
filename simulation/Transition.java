package simulation;

import java.util.Scanner;

public class Transition {

	private void Solution() {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int[] s = new int[2];
			int[] e = new int[2];
			
			// 출발점과 끝점 저장
			s[0] = sc.nextInt();
			s[1] = sc.nextInt();
			e[0] = sc.nextInt();
			e[1] = sc.nextInt();
			
			int m = Math.abs(s[0]-e[0]) + Math.abs(s[1]-e[1]); // 맨하탄 거리 구하기
			if (m <= 1) {
				System.out.println("#"+t+" "+m);
				continue;
			} else {
				if (s[0]-e[0] == 0) {
					
				} else if (s[1]-e[1] == 0) {
					
				}
				else {
					
				}
			}
			
			
			System.out.println("#"+t+" ");
		}
		
	}
	public static void main(String[] args) {
		new Transition().Solution();
	}

}
