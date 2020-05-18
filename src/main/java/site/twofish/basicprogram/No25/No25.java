package site.twofish.basicprogram.No25;

import java.util.Stack;

/**
 * @author:ganggang
 * @create:2020-05-16
 * @description:K个一组翻转
 **/


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseSection(Stack<ListNode> stack) {

        while (stack.size() > 1) {
            ListNode current = stack.pop();
            current.next = stack.peek();
        }
        ListNode end = stack.pop();
        end.next = null;
        return end;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        ListNode lastSectionEnd = null;
        while (current != null) {
            stack.push(current);
            current = current.next;
            if (stack.size() == k) {
                // 翻转这k个
                if (lastSectionEnd != null) {
                    lastSectionEnd.next = stack.peek();
                } else {
                    head = stack.peek();
                }
                lastSectionEnd = reverseSection(stack);
            }
        }
        if (stack.size() != 0) {
            lastSectionEnd.next = stack.elementAt(0);
        }
        return head;

    }
}

public class No25 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        Solution solution = new Solution();
        solution.reverseKGroup(head, 2);
    }
}
