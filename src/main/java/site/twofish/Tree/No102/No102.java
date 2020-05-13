package site.twofish.Tree.No102;

import java.util.*;

/**
 * @author:ganggang
 * @create:2020-05-13
 * @description:二叉树的层序遍历 广度优先
 **/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        int nowLevel = 0; //当前遍历的层
        int nowNodes = 1; //当前层节点的总个数
        int nextNodes = 0; //下一层的节点数
        int nowLevelNode = 0; //当前层遍历到第n个节点
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (result.size() == nowLevel) {
                List<Integer> nowLevelList = new ArrayList<>();
                nowLevelList.add(current.val);
                result.add(nowLevelList);
            } else {
                result.get(nowLevel).add(current.val);
            }
            if (current.left != null) {
                nextNodes++;
                queue.offer(current.left);
            }
            if (current.right != null) {
                nextNodes++;
                queue.offer(current.right);
            }
            nowLevelNode++;
            if (nowLevelNode == nowNodes) {
                nowLevel++;
                nowNodes = nextNodes;
                nowLevelNode = 0;
                nextNodes = 0;
            }
        }
        return result;
    }
}

public class No102 {
}
