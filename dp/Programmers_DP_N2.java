package dp;

import java.util.*;
public class Programmers_DP_N2 {
	
	public int solution(int N, int number) {
		List<Set<Integer>> list = new ArrayList<>();
		
		for (int i=0;i<=8;i++) list.add(new HashSet<>());
		
		int currNum = 0;
		for (int i = 1; i <= 8; i++) {
			currNum=currNum*10+N;
			Set<Integer> set = list.get(i);
			set.add(currNum);
		}
		
		int answer = 0;
		outer:for (int i = 1; i <= 8; i++) { // N의 전체 사용 갯수
			Set<Integer> set = list.get(i);
			for (int j = 1; j < i; j++) { // N의 기준 사용 갯수
				Iterator<Integer> iter1 = list.get(j).iterator();
				while (iter1.hasNext()) {
					Integer num1 = iter1.next();
					Iterator<Integer> iter2 = list.get(i-j).iterator();
					while (iter2.hasNext()) {
						Integer num2 = iter2.next();
						set.add(num1 + num2);
						set.add(num1 - num2);
						set.add(num1 * num2);
						if (num2 != 0) set.add(num1 / num2);
					}
				}
				if (set.contains(number)) System.out.println(j+" "+(i-j));
			}
			
			if (set.contains(number)) {
				answer = i;
				break outer;
			}
		}
		
		System.out.println(answer);
		return answer > 0? answer : -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Programmers_DP_N2().solution(5, 12);
	}

}
