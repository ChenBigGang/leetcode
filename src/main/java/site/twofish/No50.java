package site.twofish;

/**
 * @author:ganggang
 * @create:2020-05-11
 * @description:Pow(x,n) 求x的n次幂
 **/


// 分治法
class Solution1 {
    public double myPow(double x, int n) {
        long z = (long) n;
        if (x == 0) {
            return 0;
        }
        if (z < 0) {
            x = 1 / x;
            z = -z;
        } else if (z == 0) {
            return 1;
        } else if (z == 1) {
            return x;
        }
        int mid = (int) (z / 2);
        double midResult = myPow(x, mid);
        midResult *= midResult;
        if (z % 2 != 0) {
            midResult *= x;
        }
        return midResult;

    }
}

public class No50 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.myPow(2.00000, -2147483648));

    }

}
