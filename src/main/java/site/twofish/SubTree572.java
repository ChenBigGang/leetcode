package site.twofish;

import java.util.Stack;

/**
 * @author:ganggang
 * @create:2020-05-07
 * @description:572:一棵树是否是另一颗树的子树
 **/


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// 朴素算法, 遍历大树的所有子树，判断小树是否和子树相等，双层遍历
// 需要树的遍历算法 深度优先 不借助递归
class Solution1 {
    public boolean equal(TreeNode s, TreeNode t) {
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        leftStack.push(s);
        rightStack.push(t);
        boolean equalFlag = true;
        while (!rightStack.empty() && !leftStack.empty()) {
            TreeNode rightCurrent = rightStack.pop();
            TreeNode leftCurrent = leftStack.pop();
            if (leftCurrent == null || rightCurrent == null) {
                if (leftCurrent != rightCurrent) {
                    equalFlag = false;
                }
            } else if (rightCurrent.val != leftCurrent.val) {
                equalFlag = false;
                break;
            } else {
                rightStack.push(rightCurrent.right);
                rightStack.push(rightCurrent.left);
                leftStack.push(leftCurrent.right);
                leftStack.push(leftCurrent.left);
            }
        }
        // 可能只是一棵树遍历完了
        if (equalFlag) {
            if (!leftStack.empty() || !rightStack.empty()) {
                equalFlag = false;
            }
        }
        return equalFlag;
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        Stack<TreeNode> leftStack = new Stack<>();
        leftStack.push(s);
        boolean flag = false;
        while (!leftStack.empty()) {
            TreeNode current = leftStack.pop();
            if (equal(current, t)) {
                flag = true;
                break;
            } else {
                if (current.right != null) {
                    leftStack.push(current.right);
                }
                if (current.left != null) {
                    leftStack.push(current.left);
                }
            }
        }
        return flag;
    }
}

// 朴素算法, 遍历大树的所有子树，判断小树是否和子树相等，双层遍历
// 需要树的遍历算法 深度优先 借助递归
class Solution2 {

    public boolean equal(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == t;
        } else if (s.val == t.val) {
            return equal(s.left, t.left) && equal(s.right, t.right);
        } else {
            return false;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        } else {
            if (equal(s, t)) {
                return true;
            } else {
                return isSubtree(s.left, t) || isSubtree(s.right, t);
            }
        }
    }
}

public class SubTree572 {
    public static void main(String[] args) {

    }
}
