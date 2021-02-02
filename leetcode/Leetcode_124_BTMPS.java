package leetcode;

import java.util.*;

public class Leetcode_124_BTMPS {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode() {
			super();
		}
		
		public TreeNode(int val) {
			super();
			this.val = val;
		}

		public TreeNode(int val, TreeNode left, TreeNode right) {
			super();
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	private static int res;
	public int maxPathSum(TreeNode root) {
		res = Integer.MIN_VALUE;
		maxPathHelper(root);
		return res;
    }
	private static int maxPathHelper(TreeNode node) {
		
		if (node == null) return 0;
		int left = maxPathHelper(node.left);
		int right = maxPathHelper(node.right);
		
		// 루트노드로 온다.
		int maxRightLeft = Math.max(left, right);
		int maxOneNodeRoot = Math.max(node.val, (node.val + maxRightLeft));
		int maxAll = Math.max(maxOneNodeRoot, node.val+left+right);
		
		res = Math.max(res, maxAll);
		
		return maxOneNodeRoot;
	}
}
