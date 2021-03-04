package graph;

import java.util.*;
public class Programmers_Graph_Node {
	public int solution(int n, int[][] edge) {
    	boolean[][] b = new boolean[n+1][n+1]; 
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<edge.length;i++) {
            b[edge[i][0]][edge[i][1]] = b[edge[i][1]][edge[i][0]] = true;
        }
        
        int res = 0;
        boolean[] visit = new boolean[n+1];
        q.add(1);
        visit[1] = true;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
            	Integer num = q.poll();
            	for (int j = 1; j <= n; j++) {
					if (!visit[j] && (b[num][j] || b[j][num])) {
						q.add(j);
						visit[j] = true;
					}
				}
            }
            res = size;
        }
        
        System.out.println(res);
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Programmers_Graph_Node().solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
	}
}
