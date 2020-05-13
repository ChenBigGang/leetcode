package site.twofish.competition.No188;

import java.util.*;

/**
 * @author:ganggang
 * @create:2020-05-10
 * @description:
 **/

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            if (target[j] == i) {
                result.add("Push");
                j++;
            } else {
                result.add("Push");
                result.add("Pop");
            }
        }
        return result;
    }
}


class No2 {

    public int getA(int start, int end, int[] arr, int[][] temp) {
        if (temp[start][end] != 0) {
            return temp[start][end];
        } else {
            temp[start][end] = arr[end] ^ temp[start][end - 1];
            return temp[start][end];
        }
    }

    public int countTriplets(int[] arr) {
        int length = arr.length;
        int temp[][] = new int[length][length];
        for (int z = 0; z < length; z++) {
            temp[z][z] = arr[z];
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j; k < length; k++) {
                    int a = getA(i, j - 1, arr, temp);
                    int b = getA(j, k, arr, temp);
                    if (a == b) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}

public class First {

}
