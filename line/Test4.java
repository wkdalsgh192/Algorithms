package line;

public class Test4 {

	private static int[] dr = {0, -1, 0, 1, 1,0,-1,0}; // 우 상 좌 하 순으로 벽을 탐색 - 하 우 상 좌 순으로 이동
	private static int[] dc = {1, 0, -1, 0, 0,-1,0,1};
	
	public int solution(int[][] maze) {
        
		int N = maze.length;
		System.out.println(N);
		int x = 0,y = 0; // 현재 위치
		int cnt=0; // 움직인 횟수
		
		while (true) { // 도착할 때까지 반복
			System.out.println(x+" "+y);
			
			if (x == N-1 && y == N-1) break;
			
			// 벽을 탐색
			int nr,nc,nx,ny;
			boolean flag = false; // 탐색할 곳이 하나라도 있는 지 확인하는 변수
			for (int d = 0; d < 4; d++) {
				nr = x + dr[d];
				nc = y + dc[d];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || maze[nr][nc] == 1 || maze[nr][nc] == 2) { // 탐색하는 곳이 1이거나 경계를 벗어나면 벽으로 간주한다 
					nx = x + dr[d+4];
					ny = y + dc[d+4];
					// 이동하는 칸에는 벽이 없는 지확인
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue; // 움직이는 칸 경계 유효성 체크
					if (maze[nx][ny] == 0) { // 움직이려는 칸이 0이면
						flag = true;
						maze[x][y] = 2; // 움직인 칸을 벽으로 바꿔주기
						x = nx; y = ny; // 움직이기
						cnt++; // 카운트하기
						break; // 더이상 방향탐색은 필요없음
					} else continue; // 움직이려는 칸이 1이면 방향을 튼다 - 처음으로 돌아가 다음 방향을 탐색한다.
				} else continue; // 벽이 없으면 다음 방향 탐색
			}
			
			System.out.println(flag);
			
			if (!flag) { // 사방이 막혀있었다면
				for (int i = 0; i < maze.length; i++) {
					for (int j = 0; j < maze.length; j++) {
						if (maze[i][j] == 2) maze[i][j] = 0; // 더 이상 갈 곳이 없으므로 초기화해주기
					}
				}
			}
		}
		
		int answer = cnt;
        return answer;
    }
	
	public static void main(String[] args) {
		int N = 6;
		int[][] maze = new int[N][N];
		maze[0] = new int[] {0, 1, 0, 0, 0, 0};
		maze[1] = new int[] {0, 1, 0, 1, 1, 0};
		maze[2] = new int[] {0, 1, 0, 0, 1, 0};
		maze[3] = new int[] {0, 1, 1, 1, 1, 0};
		maze[4] = new int[] {0, 1, 0, 0, 0, 0};
		maze[5] = new int[] {0, 0, 0, 1, 1, 0};
		
		new Test4().solution(maze);
	}

}
