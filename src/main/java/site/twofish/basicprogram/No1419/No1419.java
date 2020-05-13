package site.twofish.basicprogram.No1419;

import java.util.*;

/**
 * @author:ganggang
 * @create:2020-05-10
 * @description:数青蛙
 **/

class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int length = croakOfFrogs.length();
        int maxCroak = (int)Math.ceil(((double) length) / 5);
        List<Map<String, Integer>> croaks = new ArrayList<>();
        char[] croak = new char[]{'c', 'r', 'o', 'a', 'k'};
        boolean[] already = new boolean[length];
        for (int i = 1; i <= maxCroak; i++) {
            int start = 0, end = 0;
            for (int j = 0, z = 0; j < length && z < 5; j++) {
                if (croakOfFrogs.charAt(j) == croak[z] && !already[j]) {
                    if (z == 0) {
                        start = j;
                    }
                    if (z == 4) {
                        end = j;
                    }
                    z++;
                    already[j] = true;
                }
            }
            // 说明成功找到青蛙叫
            if (end != 0) {
                Map<String, Integer> current = new HashMap<>(2);
                current.put("start", start);
                current.put("end", end);
                croaks.add(current);
            } else {
                return -1;
            }
        }
        Set<Integer> alreadyFlag = new HashSet<>(maxCroak);
        int num = 0;
        while (alreadyFlag.size() < maxCroak) {
            int curretEnd = -1;
            for (int i = 0; i < maxCroak; i++) {
                if (!alreadyFlag.contains(i) && croaks.get(i).get("start") > curretEnd) {
                    alreadyFlag.add(i);
                    if (curretEnd == -1) {
                        num++;
                    }
                    curretEnd = croaks.get(i).get("end");
                }
            }
        }
        return num;
    }
}

public class No1419 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minNumberOfFrogs("croakcroa"));
    }

}
