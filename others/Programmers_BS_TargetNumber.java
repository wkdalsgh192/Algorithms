package others;

import java.util.*;
public class Programmers_BS_TargetNumber {

	public long solution(int n, int[] times) {
		Arrays.sort(times);
		long left = 1, mid = 0, right = (long) times[times.length-1]*n, answer = Long.MAX_VALUE;
		while (left <= right) {
			mid = (left+right) / 2;
    	   
    	   	long total = 0;
    	   	for (int time : times) {
    		   	total += mid / time; // 각 심사대에서 해당 시간동안 처리할 수 있는 인원
    	   	}
    	   	if (total >= n) {
    	   		answer  = answer > mid ? mid : answer;
    		   	right = mid -1;
    	   	} else {
    		   	left = mid + 1;
    	   	}
		}
		System.out.println(answer);
		return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Programmers_BS_TargetNumber().solution(6, new int[] {7,10});
	}

}
