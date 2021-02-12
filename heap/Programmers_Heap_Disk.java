package heap;

import java.util.*;
public class Programmers_Heap_Disk {
public int solution(int[][] jobs) {
        
        // 요청 순서대로 정렬하기
        Arrays.sort(jobs, (a,b) -> a[0]-b[0]);        
        int time = jobs[0][0]; // 요청 순서대로 정렬된건가?
        int total = 0;
        
        int idx = 0, cnt = 0;
        List<int[]> list = new ArrayList<>();
        while (cnt < jobs.length) {
        	// 현재시간 이하의 요청시간을 가지는 작업을 모두 대기큐에서 작업 큐로 옮기기
        	for (int i = idx; i < jobs.length; i++) {
//        		System.out.println(idx);
				int[] curr = jobs[i];
				if (curr[0] > time) break;
        		list.add(curr);
        		idx++;
			}
//        	System.out.println(list.size());
        	if (!list.isEmpty()) {
        		// 작업 큐에서 가장 작업시간이 짧은 작업을 꺼내어 작업하기
        		Collections.sort(list, (a,b) -> a[1]-b[1]);
        		int[] curr = list.remove(0);
                time += curr[1];
        		total += time - curr[0];	
        		cnt++;
        	} else time++; // 작업 큐가 비어있는 경우 현재 시간 +1
//        	System.out.println(list.size());
        }
        
        System.out.println(total / jobs.length);
        return total / jobs.length;
    }
	public static void main(String[] args) {
		int[][] jobs = new int[][] {{0,3},{1,9},{2,6}};
		new Programmers_Heap_Disk().solution(jobs);

	}

}
