package hash;

import java.util.*;

public class Programmers_Hash_Spy {

	static int answer = 0;
	public int solution(String[][] clothes) {
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        Map<Integer,List<Integer>> local = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
        	// 단독으로 넣기
			String[] curr = clothes[i];
			List<Integer> list = new ArrayList<>();
			int name = curr[0].hashCode();
			int type = curr[1].hashCode();
			list.add(type);
        	map.put(name, list);
        	
        	// 조합으로 넣기
        	local.clear();
        	for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
        		List<Integer> arr = entry.getValue();
        		if (!arr.contains(type)) {
        			List<Integer> newArr = new ArrayList<>();
        			newArr.addAll(arr);
        			newArr.add(type);
        			local.put(entry.getKey()+name, newArr);
        		}
        	}
        	
        	local.forEach((k,v) -> {map.put(k, v);});
		}
        
        map.forEach((k,v) -> {
        	answer++;
    	});
        
        System.out.println(answer);
        return answer;
    }
	public int solution2(String[][] clothes) {
        
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1); // 종류별 갯수를 저장한다.
		}
        
        for (String keys: map.keySet()) answer *= (map.get(keys)+1); // (종류별로 입을 수 있는 갯수 + 안 입는 경우의 수)를 곱한다.
        
        return answer - 1;
    }
	public int solution3(String[][] clothes) {
	    HashMap<String, Integer> map = new HashMap<String, Integer>();
	    for (String[] strings : clothes) {
	      int p = 0;
	      String key = strings[1];
	      if(map.containsKey(key)){
	        p = map.get(key);
	      }
	      map.put(key, p+1);
	    }
	    Collection<Integer> values = map.values();
	    
	    Integer[] counts = new Integer[values.size()];
	    values.toArray(counts);
	    
	    int[][] dp = new int[values.size()][2]; // 각 아이템을 입는 경우와 안 입는 경우로 나눔
	    dp[0][0] = 1; // 0번째 인덱스의 아이템을 입지 않은 경우
	    dp[0][1] = counts[0]; // 1번째 인덱스의 아이텝을 입는 경우의 수
	    
	    for (int i = 1; i < dp.length; i++) {
	      dp[i][0] = dp[i-1][0] + dp[i-1][1]; // i-1번째 아이템까지에 대한 결정을 한 뒤 i번째 아이템을 안입는 경우
	      dp[i][1] = dp[i-1][0] * counts[i] + dp[i-1][1] * counts[i]; // i번째 아이템을 입기로 했을 때 그 직전 아이템을 안 입는 경우의 수 + 입는 경우의 수
	    }
	    
	    // 맨 마지막에는 총 경우의 수가 저장된다.
	    return dp[dp.length-1][0] + dp[dp.length-1][1] -1;
	  } 
	public static void main(String[] args) {
		String[][] str = new String[][] {{"yellow_hat", "a"}, {"blue_sunglasses", "b"}, {"green_turban", "c"},
			{"yellow_hat1", "d"}, {"blue_sunglasses1", "b"}, {"green_turban1", "c"},{"yellow_hat2", "e"}, {"blue_sunglasses2", "f"}, {"green_turban2", "g"},
			{"yellow_hat3", "a"}, {"blue_sunglasses3", "b"}, {"green_turban3", "c"},
			{"yellow_hat4", "d"}, {"blue_sunglasses4", "b"}, {"green_turban4", "c"},{"yellow_hat5", "e"}, {"blue_sunglasses6", "f"}, {"green_turban6", "g"},
			{"yellow_hat7", "a"}, {"blue_sunglasses7", "b"}, {"green_turban7", "c"},
			{"yellow_hat8", "c"}, {"blue_sunglasses8", "h"}, {"green_turban8", "c"},{"yellow_hat9", "e"}, {"blue_sunglasses9", "s"}, {"green_turban9", "g"},
			};
		new Programmers_Hash_Spy().solution3(str);
	}

}
