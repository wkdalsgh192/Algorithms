package others;
import java.util.*;
public class Programmers_SQ_Printer {
    static class Node {
        int idx;
        int num;
		public Node(int idx, int num) {
			super();
			this.idx = idx;
			this.num = num;
		}
    }
    public int solution(int[] priorities, int location) {
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) q.add(new Node(i,priorities[i]));

        Integer[] arr = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        
        int idx = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
        	Node curr = q.poll();
        	
        	if (curr.idx == location && curr.num == arr[idx]) {
        		++cnt;
        		break;
        	}
        	
        	if (curr.num == arr[idx]) {
        		idx++;
        		cnt++;
        	} else q.add(curr);
        }
        
        System.out.println(cnt);
        return cnt;
    }
    
    public static void main(String[] args) {
    	int[] priorities = new int[] {1,1,9,1,1,1};
    	int location = 0;
		new Programmers_SQ_Printer().solution(priorities, location);
	}
}
