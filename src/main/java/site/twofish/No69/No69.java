package site.twofish.No69;

/**
 * @author:ganggang
 * @create:2020-05-09
 * @description:第69题，x的平方根，去掉小数部分
 **/

// 最简单的方法，使用库函数
class Solution1 {
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }
}

// 二分法
class Solution2 {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = 0;
        while (l <= r) {
            int mid = (r + l) / 2;
            if ((long)mid * mid > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}

public class No69 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.mySqrt(8));
    }
}
