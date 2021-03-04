package simulation;

import java.util.*;
import java.io.*;
public class SWEA_2115_Honey {
	
	private int T,N,M,C,max,map[][],profit[][];
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 벌통 크기
			M = Integer.parseInt(st.nextToken()); // 최대 벌통 수집 수
			C = Integer.parseInt(st.nextToken()); // 최대 벌꿀 채취 수
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 각 출발 좌표에 대한 최대 수익 저장
			profit = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c <= N-M; c++) {
					settingMap(r,c,0,0,0);
				}
			}
			
			max = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c <=N-M; c++) {
					int profitSum=0;
					profitSum+=profit[r][c]; // 첫번째 일꾼의 이익 더하기
					int nr=r;
					// 두번째 일꾼이 첫번째 일꾼과 같은 라인인 경우
					for (int nc = c+M; nc<=N-M; nc++) {
						max = profitSum + profit[nr][nc] > max ? profitSum+profit[nr][nc] : max;
					}
					// 두번째 사람 이후 아래 라인
					nr++;
					while (nr<N) {
						for (int nc = 0; nc <=N-M; nc++) {
							max=profitSum+profit[nr][nc] > max ? profitSum+profit[nr][nc] : max;
						}
						nr++;
					}
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	
	}
	private void settingMap(int r,int c,int idx,int sum,int pf) {
		if (sum > C) return; // 중간에 최대치를 넘으면 그대로 리턴
		
		if (idx==M) {
			// 최대 수익 갱신하기
			profit[r][c-M] = pf > profit[r][c-M] ? pf : profit[r][c-M];
			return;
		}
		
		// 해당 벌통을 수집하기
		settingMap(r,c+1,idx+1,sum+map[r][c],pf+(int)Math.pow(map[r][c],2));
		// 해당 벌통을 수집하지 않기
		settingMap(r,c+1,idx+1,sum,pf);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new SWEA_2115_Honey().solution();
	}

}
