package graph;

public class Programmers_Graph_Rank2 {
	private int solution(int n, int[][] results) {
		int answer = 0;
		int maxValue = 1000000;
		int[][] FW = new int[n+1][n+1]; // 플로이드 와샬로 저장할 맵
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				FW[i][j] = maxValue; // 적당히 큰값으로 초기화하기
			}
		}
		
		for (int[] e : results) FW[e[0]][e[1]] = 1; // 연결된 정점(순위를 알 수 있는 것)에 대해서는 1로 저장.
		
		// 거쳐가는 노드에 대하여
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (FW[i][j] > FW[i][k]+FW[k][j])
						FW[i][j] = FW[i][k]+FW[k][j];
				}
			}
//			for (int i = 1; i <= n; i++) {
//				System.out.println();
//				for (int j = 1; j <= n; j++) {
//					System.out.print(FW[i][j]+" ");
//				}
//			}
//			System.out.println();
//			System.out.println("---------------------");
		}
		
		for (int i = 1; i <= n; i++) {
			boolean flag = true;
			for (int j = 1; j <= n; j++) {
				if (i == j) continue;
				// 두 정점 사이의 연관 관계가 하나도 없으면 정점 V(i)의 순위는 알 수 없다.
				if (FW[i][j] == maxValue && FW[j][i] == maxValue) {
					flag = false;
					break;
				}
			}
			if (flag) answer++;
		}
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Programmers_Graph_Rank2().solution(4, new int[][] {{1,2},{2,4},{4,3}});
	}

}
