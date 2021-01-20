package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Runway2 {

	static int N, X, map[][], count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 지형의 크기
			X = Integer.parseInt(st.nextToken()); // 경사로의 길이
			
			count = 0; // 건설 가능한 활주로의 경우의 수
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str.nextToken());
				}
			}
			
			process();
			System.out.println("#"+t+" "+count);
		}
	}
	
	private static void process() {
		for (int i = 0; i < N; i++) {
			// 교차하는 방법으로 가로-세로-가로-세로 순으로 시행
			if (makeRoadByRow(i)) ++count;
			if (makeRoadByCol(i)) ++count; 
		}
	}
	
	// 행단위로 활주로 건설
	private static boolean makeRoadByRow(int i) {
		
		int beforeHeight, size; // 이전칸의 높이, 평탄한 지형의 길이
		beforeHeight = map[i][0];
		size =1;
		for (int j = 1; j < N; j++) {
			// 1. 이전 칸과 현재칸의 높이가 같은지
			if (beforeHeight == map[i][j]) ++size;
			// 2. 현재 칸이 이전칸보다 높이가 1 높은 경우 (오르막 경사로 설치가능한지 체크)
			else if (beforeHeight+1 == map[i][j]) {
				if (size < X) return false; // 평탄한 지형의 길이가 경사로의 길이보다 작은 경우 활주로 건설 불가
				// 새로운 높이의 평탄한 지형 길이 1부터 시작
				beforeHeight++;
				size = 1; 
			}
			// 3. 현재 칸이 이전칸보다 높이가 1 낮은 경우 (내리막 경사로 설치가능한지 체크)
			else if (beforeHeight-1 == map[i][j]) {
				int count = 0;
				for (int k = j; k < N; k++) {
					if (map[i][k] != beforeHeight-1) break;
					count++; // 이전 칸의 높이와 1 낮은 연속된 평탄화 지형의 길이를 카운트
				}
				if (count < X) return false; // 활주로 건설 불가
				j+=X-1; // j+X만큼 건너뛰기 위해 X-1을 더해주고 다음 for-loop으로 간다. j++를 거치면 j+=X가 됨! 
				beforeHeight--;
				size = 0; // 우리가 사이즈를 세는 칸은 j+X부터이니까 j+X-1부터 설정한 현재는 사이즈가 0이 되어야한다.
			}
			// 4. 높이가 2이상 차이나는 경우
			else return false;
		}
		return true;
	}
	
	// 열단위로 활주로 건설
	private static boolean makeRoadByCol(int i) {
		
		int beforeHeight, size; // 이전칸의 높이, 평탄한 지형의 길이
		beforeHeight = map[0][i];
		size =1;
		for (int j = 1; j < N; j++) { // j가 행첨자가 된다
			// 1. 이전 칸과 현재칸의 높이가 같은지
			if (beforeHeight == map[j][i]) ++size;
			// 2. 현재 칸이 이전칸보다 높이가 1 높은 경우 (오르막 경사로 설치가능한지 체크)
			else if (beforeHeight+1 == map[j][i]) {
				if (size < X) return false; // 평탄한 지형의 길이가 경사로의 길이보다 작은 경우 활주로 건설 불가
				// 새로운 높이의 평탄한 지형 길이 1부터 시작
				beforeHeight++;
				size = 1; 
			}
			// 3. 현재 칸이 이전칸보다 높이가 1 낮은 경우 (내리막 경사로 설치가능한지 체크)
			else if (beforeHeight-1 == map[j][i]) {
				int count = 0;
				for (int k = j; k < N; k++) {
					if (map[k][i] != beforeHeight-1) break;
					count++; // 이전 칸의 높이와 1 낮은 연속된 평탄화 지형의 길이를 카운트
				}
				if (count < X) return false; // 활주로 건설 불가
				j+=X-1; // j+X만큼 건너뛰기 위해 X-1을 더해주고 다음 for-loop으로 간다. j++를 거치면 j+=X가 됨! 
				beforeHeight--;
				size = 0;
			}
			// 4. 높이가 2이상 차이나는 경우
			else return false;
		}
		return true;
	}

}
