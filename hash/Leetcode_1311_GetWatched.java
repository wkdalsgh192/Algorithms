package hash;

/*
 * 
 * https://leetcode.com/problems/get-watched-videos-by-your-friends/
 * */


import java.util.*;
import java.util.Map.Entry;
public class Leetcode_1311_GetWatched {

	static class Person {
		int id, lv;

		public Person(int id, int lv) {
			super();
			this.id = id;
			this.lv = lv;
		}
		
	}
	public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        
		List<Integer> list = new ArrayList<>();
		boolean[] visit = new boolean[friends.length];
		Queue<Person> q = new LinkedList<>();
		
		visit[id] = true;
		q.add(new Person(id,0));
		
		// BFS로 레벨 확인하고 저장하기
		while(!q.isEmpty()) {
			Person curr = q.poll();
			
			if (curr.lv > level) break;
			else if (curr.lv == level) list.add(curr.id);
			else {
				int now;
				for (int i = 0; i < friends[curr.id].length; i++) { // 현재 사람의 친구 리스트 받아오기
					now = friends[curr.id][i];
					if (!visit[now]) {
						visit[now] = true;
						q.add(new Person(now,curr.lv+1));
					}
				}
			}
		}
		
		// 맵에 넣기
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			List<String> curr = watchedVideos.get(list.get(i));
			for (int j = 0; j < curr.size(); j++) {
				map.put(curr.get(j),map.getOrDefault(curr.get(j), 0)+1);
			}
		}
		
		// 정렬하기
		List<Map.Entry<String,Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if (o1.getValue() < o2.getValue()) return -1;
				else if (o1.getValue() == o2.getValue()) return o1.getKey().compareTo(o2.getKey()); 
				else return 1;
			}	
		});
		
		List<String> answer = new ArrayList<>();
		for (Map.Entry<String,Integer> entry : entries) {answer.add(entry.getKey());}
		
		return answer;
    }
	public static void main(String[] args) {
		List<List<String>> watchedVideos = new ArrayList<>();
		int[][] friends = new int[][] {{1,2},{0,3},{0,3},{1,2}};
		int id = 0, level = 2;
		new Leetcode_1311_GetWatched().watchedVideosByFriends(watchedVideos, friends, id, level);
	}

}
