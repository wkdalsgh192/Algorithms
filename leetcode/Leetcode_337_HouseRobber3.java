/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] answer = robHelper(root); 
        return Math.max(answer[0],answer[1]);
    }
    private int[] robHelper(TreeNode tree) {
        if (tree == null) return new int[] {0,0};
        
        int[] left = robHelper(tree.left);
        int[] right = robHelper(tree.right);
        
        // 최댓값 갱신 구간 - val, left, right으로 어떻게 관계를 만드는가?
        int[] res = new int[] {tree.val+left[1]+right[1],
                              Math.max(left[0],left[1])+Math.max(right[0],right[1])};
        
        return res;
    }
}
