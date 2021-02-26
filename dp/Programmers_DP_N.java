package dp;

import java.util.*;
public class Programmers_DP_N {
	
	static int answer = -1;
	public int solution(int N, int number) {
		calc(N,number,0,0);
		return answer > 0? answer : -1;
	}
	private void calc(int n,int number,int count,int accum) {
		int nn=n; // n으로 초기화
		
		if (count>8) { // 호출 횟수가 8회가 넘으면 그냥 리턴
			answer = -1;
			return;
		}
		
		if (accum == number) { // 숫자를 찾았다.
			if (answer == -1 || answer > count) answer = count; // count 횟수보다 큰 경우 최솟값 갱신
			return;
		}
		
		if (9-count > 5) System.out.println("9-count : "+(9-count));
		for (int i = 1; i < 9-count; i++) { // 총 사용횟수가 8이 넘지 않도록 카운트 횟수를 빼준다. 안 그러면 호출될 때마다 8까지 루프돈다.
			calc(n,number,count+i,accum+nn); // 주어진 수에 사칙연산 진행해서 얻은 결과값으로 재귀
			calc(n,number,count+i,accum-nn);
			calc(n,number,count+i,accum*nn);
			calc(n,number,count+i,accum/nn);
			nn = nn*10+n; // N 사용갯수가 늘어날 때마다 nn에 N을 붙여준다.
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Programmers_DP_N().solution(5, 6);
	}

}
