package bruteforce;

import java.util.ArrayList;

public class Programmers_BF_Mock_Answer {
	public int[] solution(int[] answers) {
		int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int idx = 0;
        int r1 = 0, r2 = 0, r3 = 0;
        while (idx < answers.length) {
        	if (a[idx % 5] == answers[idx]) r1++;
        	if (b[idx % 8] == answers[idx]) r2++;
        	if (c[idx % 10] == answers[idx]) r3++;
        	
        	idx++;
        }
        
        int max = Math.max(r1, Math.max(r2, r3));
        ArrayList<Integer> list = new ArrayList<>();
        if (r1 == max) list.add(1);
        if (r2 == max) list.add(2);
        if (r3 == max) list.add(3);
        return list.stream().mapToInt(i->i.intValue()).toArray();
	}
}
