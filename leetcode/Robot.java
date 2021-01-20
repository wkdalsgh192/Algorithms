package leetcode;


class Solution {
    public boolean isRobotBounded(String instructions) {
		
		boolean answer = false; // the robot is set to leave the circle at first
		char[] arr = instructions.toCharArray();
		
		int idx = 0;
		int dir = 0;
		int[] pos = new int[] {0,0};
		int[] dx = new int[] {0,1,0,-1};
		int[] dy = new int[] {1,0,-1,0};
		
		while (idx < 4) {
			for (int i = 0; i < arr.length; i++) {
				char ins = arr[i];
				switch (ins) {
				case 'G':
					int nx = pos[0] + dx[dir];
					int ny = pos[1] + dy[dir];
					
					pos = new int[] {nx, ny};
					break;
				case 'L':
					if (dir == 0) dir = 3;
			        else dir = (dir - 1);
					break;
				case 'R':
					dir = (dir + 1) % 4;
					break;
				}
			}
			
			if (pos[0] == 0 && pos[1] == 0 && dir == 0) {
				answer = true;
				break;
			}
			
			idx++;
		}
		
		
		return answer;
	}
}
