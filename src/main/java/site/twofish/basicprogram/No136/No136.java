package site.twofish.basicprogram.No136;

/**
 * @author:ganggang
 * @create:2020-05-14
 * @description:只出现一次的数字
 **/

// 异或运算具有交换律，服了，相同数字异或得零，与零异或得本身
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}

public class No136 {
}
