package leetcode;

import java.util.*;

/**
 * Leetcode_854_KSS
 */
public class Leetcode_854_KSS_Answer {

    public int kSimilarity(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        return backtrack(A, B, map, 0);
    }

    private int backtrack(String A, String B, Map<String, Integer> map, int i) {
        StringBuilder sb = new StringBuilder(A);
        if (B.equals(sb.toString()))
            return 0;
        if (map.containsKey(sb.toString()))
            return map.get(sb.toString());

        int min = Integer.MAX_VALUE;
        while (i < sb.length() && sb.charAt(i) == B.charAt(i)) // 다른 부분 찾기
            i++;
        for (int j = i + 1; j < B.length(); j++) { // 찾고자 하는 문자열이 있을 때마다
            if (sb.charAt(j) == B.charAt(i)) {
                int next = backtrack(swap(i, j, sb), B, map, i + 1);
                if (next != Integer.MAX_VALUE)
                    min = Math.min(min, next + 1);
                swap(i, j, sb); // 원래대로 돌려준다.
            }
        }

        map.put(sb.toString(), min);
        return min;
    }

    static String swap(int i, int j, StringBuilder sb) {
        char temp = sb.charAt(j);
        sb.setCharAt(j, sb.charAt(i));
        sb.setCharAt(i, temp);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_854_KSS_Answer().kSimilarity("abcbca", "ababcc")); // 1
    }
}