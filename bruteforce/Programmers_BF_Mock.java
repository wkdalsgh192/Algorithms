import java.util.*;
public class Programmers_BF_Mock {
	
	public int[] solution(int[] answers) {
        int[] one = new int[] {1,2,3,4,5};
        int[] two = new int[] {2,1,2,3,2,4,2,5};
        int[] three = new int[] {3,3,1,1,2,2,4,4,5,5};
        
        int cnt = 0;
        int[] res = new int[3];
        while (true) {
            if (cnt == answers.length) break;
            
            if (one[cnt % 5] == answers[cnt]) res[0]++;
            if (two[cnt % 8] == answers[cnt]) res[1]++;
            if (three[cnt % 10] == answers[cnt]) res[2]++;
            
            cnt++;
        }
        
        int max = 0, size = 0;
        for (int i : res) max = Math.max(max, i);
        for (int i : res) if (i == max) size++;
        
        int idx = 0;
        int[] answer = new int[size];
        for (int i = 0; i < answer.length; i++) if (res[i] == max) answer[idx++] = i+1;
        for (int i : answer) System.out.println(i);
        return answer;
    }
	public static void main(String[] args) {
		new Programmers_BF_Mock().solution(new int[] {1,3,2,4,2,1,2,3,4,1,2,3,4,5});

	}

}
