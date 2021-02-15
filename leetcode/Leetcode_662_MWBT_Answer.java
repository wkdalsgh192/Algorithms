package leetcode;

import java.util.*;

public class Leetcode_662_MWBT_Answer {
	
	public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
	
	public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>(); // 각 레벨의 노드를 저장하기 위함
        Map<TreeNode, Integer> m = new HashMap<TreeNode, Integer>(); // 각 노드의 위치가 여기에 저장된다.
        q.offer(root);
        m.put(root, 1);
        int curW = 0;
        int maxW = 0;
        while (!q.isEmpty()) {
        	int start = 0, end = 0, size = q.size();
        	for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (i == 0) start = m.get(node);
				if (i == size-1) end = m.get(node);
				if (node.left != null) {
					m.put(node.left, m.get(node)*2);
					q.offer(node.left);
				}
				if (node.right != null) {
					m.put(node.right, m.get(node)*2+1);
					q.offer(node.right);
				}
			}
        	curW = end - start + 1;
        	maxW = Math.max(curW, maxW);
        	
        }
        return maxW;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
