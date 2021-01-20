package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HoneyComb_Solution {

	private static int T,N,M,C;
	private static int[][] map,maxMap;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 벌집의 크기
			M = Integer.parseInt(st.nextToken()); // 벌통의 갯수
			C = Integer.parseInt(st.nextToken()); // 최대 채취가능한 벌꿀의 양
			
			map = new int[N][N];
			maxMap = new int[N][N];
			
			// 벌집 저장하기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#"+tc+ " "+getMaxBenefit());
		}

	}
	
	private static int getMaxBenefit() {
		makeMaxMap();
		
		return processCombination();
	}

	private static int processCombination() {

		int max = 0, aBenefit = 0, bBenefit = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) { // 일꾼 A 선택
				aBenefit = maxMap[i][j];
				// 일꾼 B선택
				// 같은 행
				bBenefit = 0;
				for (int j2 = j+M; j2 <= N-M; j2++) {
					if (bBenefit < maxMap[i][j2]) bBenefit = maxMap[i][j2];
				}
				// 다른 행
				for (int i2 = i+1; i2 < N; i2++) {
					for (int j2 = 0; j2 <= N-M; j2++) {
						if (bBenefit < maxMap[i2][j2]) bBenefit = maxMap[i2][j2];
					}
				}
				if (max < aBenefit + bBenefit) max = aBenefit + bBenefit;
			}
		}
		
		return max;
	}

	private static void makeMaxMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) {
				makeMaxSubset(i, j, 0, 0, 0);
			}
		}
	}

	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum) {
		
		if (sum > C) return;
		if (cnt == M) {
			if (maxMap[i][j-M] < powSum) maxMap[i][j-M] = powSum;
			return;
		}
		
		// 선택
		makeMaxSubset(i, j+1, cnt+1, sum+map[i][j], powSum + map[i][j]*map[i][j]);
		// 비선택
		makeMaxSubset(i, j+1, cnt+1, sum, powSum);
	}

}
