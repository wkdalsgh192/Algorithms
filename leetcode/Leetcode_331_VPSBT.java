package leetcode;

/**
 * Leetcode_331_VPSBT
 */
public class Leetcode_331_VPSBT {
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");

        if (arr[0].equals("#")) {
            if (arr.length > 1)
                return false;
            else
                return true;
        }

        boolean flag = false;
        int idx = 0, minLen = 1;
        while (true) {
            if (!arr[idx].equals("#"))
                minLen += 2;

            if (minLen > arr.length)
                return flag;
            else if (idx >= minLen - 1 && minLen < arr.length)
                return flag;
            else if (idx == minLen - 1 && minLen == arr.length)
                return flag = true;

            idx++; // 다음 노드로 이동
        }
    }
}