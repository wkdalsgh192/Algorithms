package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class HoneyComb {

	private static int T, N, M, C;
	private static int[] honey;
	private static int[][] comb;
	private static List<int[]> list = new ArrayList<>();
	private void Solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 벌집의 크기
			M = Integer.parseInt(st.nextToken()); // 벌통의 갯수
			C = Integer.parseInt(st.nextToken()); // 최대 채취가능한 벌꿀의 양
			
			comb = new int[N][N];
			honey = new int[M]; // 일꾼의 벌통
			
			// 벌집 저장하기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					comb[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 두 일꾼의 벌집 선택하기
			int max = Integer.MIN_VALUE;
			int maxA = 0;
			int maxB = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (j + M > N) continue;
				
					// 첫번째, 두 번째 일꾼의 가능한 배열을 선택
					getHoney(i, j);
					
					// 첫번째 일꾼의 최대치 찾기
					maxA = maxHoney(list.get(0), 0);
					for (int k = 1; k < list.size(); k++) {
						maxB = maxHoney(list.get(k), maxB);
					}
					
					max = Math.max(max, maxA + maxB);
				}
			}
			
			System.out.println(max);
			
		}
			
	}
	
	private static int maxHoney(int[] honey, int maxVal) {
		// 오름차순으로 정렬하기
		Arrays.sort(honey);
		
		int idx=0;
		int init = 0;
		for(int i : honey) init += i;
		
		while (init > C) {
			init -= honey[idx];
			honey[idx] = 0;
			idx++;
		}
		
		int total = 0;
		for (int i : honey) total += i!=0?i*i:0;
		
		if (total > maxVal) maxVal = total;
		
		return maxVal;
	}
	
	private static void getHoney(int r, int c) { // 첫번째 일꾼의 벌집 좌표를 넣어준다를 넣어준다.
		
		list.clear();
		
		// 첫번째 벌집의 좌표를 넣기
		Arrays.fill(honey, 0);
		for (int k = 0; k < M; k++) honey[k] = comb[r][c+k];
		list.add(honey);
		
		for (int i = r; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == r && j < c+M) continue;
				if (j+M > N) continue;
				Arrays.fill(honey, 0);
				for (int k = 0; k < M; k++) honey[k] = comb[i][j+k];
				list.add(honey);
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new HoneyComb().Solution();
	}

}
