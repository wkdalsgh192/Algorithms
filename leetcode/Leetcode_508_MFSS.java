package leetcode;

// 508. Most Frequent Subtree Sum
// https://leetcode.com/problems/most-frequent-subtree-sum/
import java.util.*;
import java.util.stream.Collectors;
public class Leetcode_508_MFSS {

	static Map<Integer,Integer> map;
	public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        findSumHelper(root);
        Integer max = map.values().stream().max(Integer::compare).orElse(Integer.MIN_VALUE);
        int[] arr = map.entrySet().stream().filter(x -> x.getValue() == max).mapToInt(x -> x.getKey()).toArray();
        return arr;
        
    }
    private static int findSumHelper(TreeNode tree) {
        if (tree == null) return 0;
        
        int left = findSumHelper(tree.left);
        int right = findSumHelper(tree.right);
        
        int sum = tree.val + left + right;
        map.put(sum, map.getOrDefault(sum, 0)+1);
        return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int maxFreq = 0; // 최대빈도값 관리
    int count = 0; // 배열 크기 관리 변수
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        traverse(root, map);
        int[] res = new int[count]; // 빈도 수만큼 배열 생성
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                res[i++] = entry.getKey(); // 저장
            }
        }
        return res;
    }
    
    private int traverse(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        
        int left = traverse(root.left, map);
        int right = traverse(root.right, map);
        
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        if (map.get(sum) > maxFreq) { //빈도값 갱신
            maxFreq = map.get(sum);
            count = 1; // 최대 빈도 수
        } else if (map.get(sum) == maxFreq) {
            count++; // 빈도 수 증가
        }
        return sum;
    }

}
