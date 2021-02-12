package heap;
import java.util.*;
public class Programmers_Heap_DoubleQ {

	public int[] solution(String[] operations) {
        LinkedList<Integer> pq = new LinkedList<>();
        
		for (String str : operations) {
        	String[] arr = str.split(" ");
        	int num = Integer.parseInt(arr[1]);
        	if (arr[0].equals("I")) pq.add(num);
        	else {
        		Collections.sort(pq, (a,b) -> a-b);
        		if (!pq.isEmpty()) {
        			if (num == -1) pq.pollFirst(); //최솟값 삭제
            		else pq.pollLast(); // 최대값 삭제
        		}
        		
        	}
        }
		
		int[] answer = new int[] {0,0};
		Collections.sort(pq, (a,b) -> a-b);
		if (!pq.isEmpty()) {
			if (pq.size() >= 2) answer = new int[] {pq.pollLast(),pq.pollFirst()};
			else answer = (pq.peek() > 0) ? new int[] {pq.poll(),0} : new int[] {0,pq.poll()}; 
		}
		return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
