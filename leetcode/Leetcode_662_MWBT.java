package leetcode;

import java.util.*;

public class Leetcode_662_MWBT {
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

    static int maxDepth, arr[];
    static Map<Integer, Integer> map;

    public int widthOfBinaryTree(TreeNode root) {
        arr = new int[3000];
        map = new HashMap<>();
        depthFindHelper(root, 0);
        widthFindHelper(root, 0);
        int max = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return max;
    }

    private static void depthFindHelper(TreeNode tree, int depth) {
        if (tree == null) {
            maxDepth = Math.max(maxDepth, depth);
            return;
        }

        depthFindHelper(tree.left, depth + 1);
        depthFindHelper(tree.right, depth + 1);
        return;
    }

    private static int widthFindHelper(TreeNode tree, int depth) {
        if (tree == null) {
            if (map.getOrDefault(depth, 0) > 0) {
                arr[depth]++;
                int cnt = 1;
                for (int i = depth + 1; i <= maxDepth; i++) {
                    cnt *= 2;
                    arr[i] += cnt;
                }
            }
            return 0;
        }

        int left = widthFindHelper(tree.left, depth + 1);

        if (left > 0) {
            int cnt = 1;
            if (arr[depth + 1] > 0) {
                cnt += arr[depth + 1];
                arr[depth + 1] = 0;
            }
            map.put(depth + 1, map.getOrDefault(depth + 1, 0) + cnt);
        }
        int right = widthFindHelper(tree.right, depth + 1);

        if (right > 0) {
            int cnt = 1;
            if (arr[depth + 1] > 0) {
                cnt += arr[depth + 1];
                arr[depth + 1] = 0;
            }

            map.put(depth + 1, map.getOrDefault(depth + 1, 0) + cnt);
        }

        return tree.val;
    }
};
