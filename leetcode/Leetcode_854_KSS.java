package leetcode;

import java.util.*;

/**
 * Leetcode_854_KSS
 */
public class Leetcode_854_KSS {
    public int kSimilarity(String A, String B) {
        // 맨 앞부터 일치하지 않는 캐릭터를 찾아서 바꿔 큐에 넣는 함수
        HashSet<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        seen.add(A);
        int step = 0;
        
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) { // 한 스텝마다 만들 수 있는 모든 문자열을 큐에 담아서 처리한다.
                String str = q.poll();
                if (str.equals(B))
                    return step;
                int i = 0;
                while (i < str.length() && str.charAt(i) == B.charAt(i))
                    i++;
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == B.charAt(j) || str.charAt(j) != B.charAt(i))
                        continue;
                    String newStr = swap(str, i, j); // str에는 영향을 주지 않는다.
                    q.offer(newStr);
                    seen.add(newStr);
                }
            }
            step++;
        }
    }

    static String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_854_KSS().kSimilarity("abcbca", "ababcc")); // 1
    }
}