package leetcode;

import java.util.*;

/**
 * Leetcode_854_KSS
 */
public class Leetcode_854_KSS {
    static StringBuilder a;
    static Map<String, Integer> map = new HashMap<>();
    static Queue<String> q = new LinkedList<>();

    public int kSimilarity(String A, String B) {
        // 맨 앞부터 일치하지 않는 캐릭터를 찾아서 바꿔 큐에 넣는 함수
        if (A.equals(B))
            return 0;

        addQ(A, B);

        // 큐에서 빼내서 만들기
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            String curr = q.poll(); // String을 불러옴

            if (B.equals(curr))
                min = Math.min(min, map.get(curr));

            // B랑 다른 경우
            addQ(curr, B);
        }

        return min;
    }

    static void addQ(String A, String B) {
        a = new StringBuilder(A);
        // 맨 앞부터 일치하지 않는 캐릭터를 찾아서 바꿔 큐에 넣는 함수
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != B.charAt(i)) { // aacc acac acca
                for (int j = i + 1; j < a.length(); j++) {
                    if (a.charAt(j) == B.charAt(i)) {
                        System.out.println(a.toString());
                        String str = swap(i, j, a);
                        System.out.println(a.toString());
                        // 변형된 str이 이미 있으면 최솟값을 선택해야함. 아예 없으면 원래 값 +1을 해야함
                        if (map.containsKey(str))
                            map.put(str, Math.min(map.get(str), map.getOrDefault(A, 0) + 1));
                        else
                            map.put(str, map.getOrDefault(A, 0) + 1);
                        q.add(str);
                        swap(i, j, a);
                        System.out.println(a.toString());
                        System.out.println("---------");
                    }
                }
                break;
            }
        }
    }

    static String swap(int i, int j, StringBuilder sb) {
        char temp = sb.charAt(j);
        sb.setCharAt(j, sb.charAt(i));
        sb.setCharAt(i, temp);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_854_KSS().kSimilarity("abcbca", "ababcc")); // 1
    }
}