package site.twofish.basicprogram.No680;

/**
 * @author:ganggang
 * @create:2020-05-19
 * @description: 验证回文字符串
 **/

class Solution {

    public boolean valid(String s, int start, int end) {
        boolean flag = true;
        while (end > start) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        boolean result = true;
        while (end > start) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                result = valid(s, start + 1, end) || valid(s, start, end - 1);
                break;
            }
        }
        return result;
    }
}

public class No680 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome("deeee"));
    }
}
