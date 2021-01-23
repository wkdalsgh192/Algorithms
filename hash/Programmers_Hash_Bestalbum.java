package hash;

import java.util.*;
import java.util.Map.Entry;

public class Programmers_Hash_Bestalbum {

	static List<Integer> answer = new ArrayList<>();
	public int[] solution(String[] genres, int[] plays) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < plays.length; i++) map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
		
		List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if (o1.getValue() < o2.getValue()) return 1;
				else if (o1.getValue() == o2.getValue()) return 0;
				else return -1;
			}
		});
		
		
		for(Map.Entry<String, Integer> entry:list) {
			Map<Integer,Integer> newMap = new HashMap<>();
			for (int i = 0; i < plays.length; i++) {
				if (genres[i].equals(entry.getKey())) newMap.put(i, plays[i]);
			}
			List<Map.Entry<Integer,Integer>> arr = new ArrayList<>(newMap.entrySet());
			Collections.sort(arr, new Comparator<Map.Entry<Integer, Integer>>() {

				@Override
				public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
					if (o1.getValue() < o2.getValue()) return 1;
					else if (o1.getValue() > o2.getValue()) return -1;
					else return Integer.compare(o1.getKey(), o2.getKey());
				}
			});
			
			answer.add(arr.get(0).getKey());
			if (arr.size()>1) answer.add(arr.get(1).getKey());
			for(Map.Entry<Integer, Integer> curr : arr) System.out.println(curr.getKey());
		}
		
		int[] res = new int[answer.size()];
		for (int i = 0; i < res.length; i++) res[i] = answer.get(i);
		
		System.out.println(answer.toString());
		return res;
	}
	public static void main(String[] args) {
		String[] str = new String[] {"classic", "classic", "classic", "classic", "classic"};
		int[] plays = new int[] {600, 600, 600, 600, 600};
		
		new Programmers_Hash_Bestalbum().solution(str,plays);
	}

}
