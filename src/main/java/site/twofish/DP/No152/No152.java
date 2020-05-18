package site.twofish.DP.No152;


import java.util.ArrayList;
import java.util.List;

/**
 * @author:ganggang
 * @create:2020-05-18
 * @description:乘积最大连续子数组
 **/
class Solution {
    public int maxProduct(int[] nums) {
        List<Integer> max = new ArrayList<>();
        List<Integer> min = new ArrayList<>();
        max.add(nums[0]);
        min.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max.add(Math.max(max.get(i - 1) * nums[i], nums[i]));
                min.add(Math.min(min.get(i - 1) * nums[i], nums[i]));
            } else {
                max.add(Math.max(min.get(i - 1) * nums[i], nums[i]));
                min.add(Math.min(max.get(i - 1) * nums[i], nums[i]));
            }
        }
        int res = max.get(0);
        for (int i = 1; i < max.size(); i++) {
            if (max.get(i) > res) {
                res = max.get(i);
            }
        }
        return res;
    }
}

public class No152 {
}
