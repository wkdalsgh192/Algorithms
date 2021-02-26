package simulation;

import java.util.*;
import java.io.*;

public class BOJ_17406_Rotate4 {
	
	private static int N,M,K,max;
	private static int[] dr = {0,1,0,-1};
	private static int[] dc = {1,0,-1,0};
	private static int[][] arr,rotate;
	private static boolean[] visit;
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // row
		M = Integer.parseInt(st.nextToken()); // col
		K = Integer.parseInt(st.nextToken()); // 회전 연산의 갯수
		
		arr = new int[N+1][M+1]; // (1,1)부터 시작한다.
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotate = new int[K+1][]; // 인덱싱을 위해 1부터 시작한다
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			rotate[i] = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
		}
		
		max = Integer.MAX_VALUE;
		visit = new boolean[K+1];
		permutation(0, new int[K]);
		
		System.out.println(max);
	}
	private static void permutation(int cnt, int[] order) {
		if (cnt == K) {

			// 회전 연산 수행
			int[][] temp = new int[N+1][M+1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			rotateMap(order,temp);
		}
		
		for (int i = 1; i <= K; i++) {
			if (visit[i]) continue;
			order[cnt] = i;
			visit[i] = true;
			permutation(cnt+1,order);
			visit[i] = false;
		}
	}
	private static void rotateMap(int[] order, int[][] arr) {
		// 임시 배열 만들기
		int[][] temp = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		
		// 각 order에 대하여 순차적으로 진행
		for (int k = 0; k < order.length; k++) {
			// 현재 회전 연산
			int[] curr = rotate[order[k]];
			int r=curr[0]-curr[2], c=curr[1]-curr[2], s=2*curr[2]; // 시작 좌표, 사이즈
			
			// 동,남,서,북으로 각각 size 만큼 이동 -> size가 1보다 작거나 같을 때까지
			int nr=r,nc=c,num=0,dir=-1;
			while (s > 1) {
				// 사이즈만큼 이동하면서 회전하기
				for (int i = 0; i < 4; i++) { // 동,남,서,북으로 진행
					dir++;
					for (int j = 0; j < s; j++) { // size만큼 이동
						num = arr[nr][nc];
						nr += dr[dir];
						nc += dc[dir];
						temp[nr][nc] = num; // 임시 배열에 저장하기
					}
				}
				
				// 좌표 및 사이즈 값 갱신하기
				nr += 1;
				nc += 1;
				s -= 2;
				dir=-1;
			}
			
			// 임시 배열을 원배열로 옮겨주기 - arr이 다음 재귀 호출 때 동일하지 않는 문제 발생
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					arr[i][j] = temp[i][j];
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.println();
			for (int j = 1; j <= M; j++) {
				System.out.print(arr[i][j]+" ");
			}
		}
		System.out.println();
		System.out.print("-------------");
		
		// A의 값 구하고 최솟값 갱신
		int local = 0;
		for (int i = 1; i <= N ; i++) {
			local = 0;
			for (int num : arr[i]) local += num;
//			System.out.println(max+" "+local);
			max = Math.min(max, local);
		}
	}
	public static void main(String[] args) throws IOException {
		new BOJ_17406_Rotate4().solution();

	}

}
