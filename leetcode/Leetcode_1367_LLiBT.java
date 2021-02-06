package leetcode;

public class Leetcode_1367_LLiBT {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	}
	private static boolean answer;
    public boolean isSubPath(ListNode head, TreeNode root) {
        boolean answer = pathFindHelper(head,root);
           
        if (!answer && root != null) 
        	return isSubPath(head, root.left) | isSubPath(head, root.right);
        
        return answer;
    }
    
    private static boolean pathFindHelper(ListNode curr, TreeNode root) { // res는 현재까지의 결과값 저장
        if (curr == null) return true;
        
        if (root == null) return false;
        
        if (curr.val == root.val) {
        	return pathFindHelper(curr.next, root.left) | pathFindHelper(curr.next, root.right);
        }
        
		return false;
        
    }
	public static void main(String[] args) {

	}

}
