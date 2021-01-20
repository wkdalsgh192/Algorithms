package map;

import java.util.*;

/*
 * https://leetcode.com/problems/find-common-characters/
 */

public class Leetcode1002_FCC {

	public List<String> commonChars(String[] A) {
        
        int N = A.length;
        HashMap<Character, Integer> map = new HashMap<>(); // 공통 key, value만 담기
        
        char[] arr;
        arr = A[0].toCharArray();
    	for (int i = 0; i < arr.length; i++) 
    		if (map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1);
    		else map.put(arr[i],1);
    	
    	HashMap<Character, Integer> local= new HashMap<>();
        if (N > 1) {
        	for (int i = 1; i < N; i++) {
				arr = A[i].toCharArray();
				local.clear();
				map.forEach((k,v) -> {local.put(k,v);});
				for (int j = 0; j < arr.length; j++) {
					if (local.containsKey(arr[j]) && local.get(arr[j]) > 0) local.replace(arr[j], -1);
					else if (local.containsKey(arr[j]) && local.get(arr[j]) < 0) local.replace(arr[j], local.get(arr[j])-1);
				}
				local.forEach((k,v) -> {
					if (map.get(k) == v) map.remove(k, v);
					else if (v < 0) map.replace(k, Math.min(map.get(k), Math.abs(v)));
				});
			}
        }
        
        List<String> list = new LinkedList<>();
		map.forEach((ch,i) -> {
			for (int j = 0; j < i; j++) list.add(ch.toString());
		});
		
		System.out.println(list.toString());
        
        return list;
    }
	public static void main(String[] args) {
		String[] A = new String[] {"bcaddcdd","cbcdccdd","ddccbdda","dacbbdad","dababdcb","bccbdaad","dbccbabd","accdddda"};
		new Leetcode1002_FCC().commonChars(A);
	}

}
