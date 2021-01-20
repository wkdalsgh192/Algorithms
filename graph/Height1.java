package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 키 순서 플로이드 와샬로 풀기
public class Height1 {

	private static int N,M;
	private static int[][] adj;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 학생 수
		M = Integer.parseInt(br.readLine()); // 관계 수
		
		adj = new int[N+1][N+1];
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			adj[i][j] = 1;
		}
		
		// 경유지 고정
		for (int k = 0; k < N; k++) { // 경유지
			for (int i = 0; i < N; i++) { // 출발지
				if (i == k) continue;
				for (int j = 0; j < N; j++) { // 도착지
					if (i == j || j == k || adj[i][j] == 1) continue; // 경유지와 출발지, 출발지와 도착지가 같거나 이미 관계가 있으면 스킵
					if (adj[i][k] == 1 && adj[k][j] == 1) adj[i][j] = 1;
				}
			}
		}
		
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				adj[i][0] += adj[i][j];
				adj[0][j] += adj[j][i];
			} 
		}
		
		for (int k = 0; k <= N; k++) {
			if (adj[k][0] + adj[0][k] == N-1) answer++;
		}
		System.out.println(answer);

	}

}
