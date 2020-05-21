package site.twofish.basicprogram.No1371;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:ganggang
 * @create:2020-05-20
 * @description:每个元音包含偶数次的最长子字符串
 **/

class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prev = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now == 'a') {
                prev ^= 1 << 4;
            } else if (now == 'e') {
                prev ^= 1 << 3;
            } else if (now == 'i') {
                prev ^= 1 << 2;
            } else if (now == 'o') {
                prev ^= 1 << 1;
            } else if (now == 'u') {
                prev ^= 1;
            }
            if (map.get(prev) == null) {
                map.put(prev, i);
            } else {
                res = Math.max(res, i - map.get(prev));
            }
        }
        return res;
    }
}

public class No1371 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("solution = " + solution.findTheLongestSubstring("bcbcbc"));
    }
}
