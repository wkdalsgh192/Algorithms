package graph;

import java.util.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
public class Programmers_Graph_Rank {
	class Player {
        int code;
        Set<Integer> win = new HashSet<>();
        Set<Integer> lose = new HashSet<>();
        
        public Player(int code) { // num에게 강한 사람들 리스트, 약한 사람들 리스트
            this.code = code;
        }
    }
    public int solution(int n, int[][] results) {
    	int answer = 0;
    	List<Player> players = new ArrayList<>();
    	
        
        // 객체 초기화
        for(int i=0;i<=n;i++) {
            players.add(new Player(i));
        }
        
        // 객체에 기록 저장하기
        for (int[] result : results) {
            players.get(result[0]).win.add(result[1]); // 이긴 기록 추가
            players.get(result[1]).lose.add(result[0]); // 진 기록 추가
        }
        
        // 기록 종합하기
        for (int depth = 0; depth < n; depth++) { // 한 번 더 depth가 들어갈 수 있기 때문에 최대 n번까지 반복
			for (int i = 1; i <= n; i++) {
				Player player = players.get(i); // 현재 플레이어
				
				Set<Integer> winSet = new HashSet<>();
				
				for (Integer win : player.win) { // 플레이어가 이긴 상대에 대하여
					for (Integer w : players.get(win).win) winSet.add(w); // 상대가 이긴 기록을 모두 추가
				}
				
				player.win.addAll(winSet);
				
				Set<Integer> loseSet = new HashSet<>();
				
				for (Integer lose : player.lose) {
					for (Integer l : players.get(lose).lose) loseSet.add(l);
				}
				
				player.lose.addAll(loseSet);
			}
		}
        
        for (Player player : players) {
        	int size = player.win.size() + player.lose.size();
        	
        	if (size == n-1) answer++;
        }
        
        return answer;
        
    }
    
    @Test
    public void 정답() {
      Assert.assertEquals(2, solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }
}
