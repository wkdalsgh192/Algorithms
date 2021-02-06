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
        for (int i = 0; i < priorities.length; i++)
            q.add(new Node(i, priorities[i]));

        Arrays.stream(priorities).boxed().toArray(Integer[]::new);

        int idx = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.idx == location && curr.num == priorities[idx])
                break;

            if (curr.num == priorities[idx]) {
                idx++;
                cnt++;
            } else
                q.add(curr);
        }

        return cnt;
    }
}
