package ssafy;

import java.io.*;
import java.util.*;

public class Road {

	static int W,H,ans,map[][];
	static List<int[]> houses;
	static StringTokenizer st;
	private static void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			// 지도 만들고 집 좌표 저장
			map = new int[H][W];
			houses = new ArrayList<>();
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) houses.add(new int[] {i,j});
				}
			}
			
			ans = Integer.MAX_VALUE;
			// 가로 도로 계산
			for (int i = 0; i < H; i++) {
				if (canBuildRow(i)) calcRow(i);
			}
			// 세로 도로 계산
			for (int i = 0; i < W; i++) {
				if (canBuildCol(i)) calcCol(i);
			}
			// 대각선 오른쪽 도로 계산
			for (int i = 1; i < W; i++) {
				if (canBuildRec(i)) {
					calcRec(0,i);
					calcRec2(0,i);
				}
			}
			System.out.println("#"+t+" "+ans); 
		}
	}
	private static boolean canBuildRow(int r) {
		for (int i = 0; i < W; i++) { // 여기도 가로 기준으로 됨
			if (map[r][i] == 1) return false; // 여기도 마찬가지
		}
		return true;
	}
	private static boolean canBuildCol(int c) {
		for (int i = 0; i < H; i++) { // 여기도 가로 기준으로 됨
			if (map[i][c] == 1) return false; // 여기도 마찬가지
		}
		return true;
	}
	private static boolean canBuildRec(int k) {
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				if (i+j != k) continue;
				if (map[i][j] == 1) return false;
			}
		}
		return true;
	}
	private static void calcRow(int s) {
		int[] houseLength = new int[houses.size()]; // 여기 바꿔야함
		for (int i = 0; i < houses.size(); i++) {
			int[] house = houses.get(i);
			// 도로 좌표를 비교해보면서 들어가기
			for (int j = 0; j < W; j++) {
				int res = Math.abs(house[0] - s) + Math.abs(house[1]-j);
				if (res != 0) {
					if (houseLength[i] == 0) houseLength[i] = res;
					else houseLength[i] = Math.min(houseLength[i], res);
				}
				
			}
		}
		
		int max = 0;
		for (int i : houseLength) max = Math.max(max, i);
		ans = Math.min(ans, max);
		return;
	}
	private static void calcCol(int c) {
		int[] houseLength = new int[houses.size()]; // 여기 바꿔야함
		for (int i = 0; i < houses.size(); i++) {
			int[] house = houses.get(i);
			// 도로 좌표를 비교해보면서 들어가기
			for (int j = 0; j < H; j++) {
				int res = Math.abs(house[0] - j) + Math.abs(house[1]-c);
				if (res != 0) {
					if (houseLength[i] == 0) houseLength[i] = res;
					else houseLength[i] = Math.min(houseLength[i], res);
				}
				
			}
		}
		
		int max = 0;
		for (int i : houseLength) max = Math.max(max, i);
		ans = Math.min(ans, max);
		return;
	}
	private static void calcRec(int r, int c) { // r이 대각선 길이가 된다.
		int[] houseLength = new int[houses.size()];
		for (int i = 0; i < houses.size(); i++) {
			int[] house = houses.get(i);
			int tempR = r, tempC = c;
			while (tempR > 0 && tempR > 0) {
				int res = Math.abs(house[0] - tempR) + Math.abs(house[1]-tempC);
				if (res != 0) {
					if (houseLength[i] == 0) houseLength[i] = res;
					else houseLength[i] = Math.min(houseLength[i], res);
				}
				
				tempR++;
				tempC--;
			}
		}
		
		int max = 0;
		for (int i : houseLength) max = Math.max(max, i);
		ans = Math.min(ans, max);
		return;
	}
	private static void calcRec2(int r, int c) { // r,c에서 대각선을 출발
		int[] houseLength = new int[houses.size()];
		for (int i = 0; i < houses.size(); i++) {
			int[] house = houses.get(i);
			int tempR = r, tempC = c;
			while (tempR < H && tempC < W) {
				int res = Math.abs(house[0] - tempR) + Math.abs(house[1]-tempC);
				if (res != 0) {
					if (houseLength[i] == 0) houseLength[i] = res;
					else houseLength[i] = Math.min(houseLength[i], res);
				}
				tempR++;
				tempC++;
			}
		}
		
		int max = 0;
		for (int i : houseLength) max = Math.max(max, i);
		ans = Math.min(ans, max);
		return;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Road().solution();
	}

}
