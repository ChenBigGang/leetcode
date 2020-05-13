package site.twofish.basicprogram.No155;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author:ganggang
 * @create:2020-05-12
 * @description:最小栈
 **/
class MinStack {
    private Stack<Integer> valueStack;
    private Stack<Integer> minStack;

    public MinStack() {
        valueStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        valueStack.push(x);
        if (minStack.empty()) {
            minStack.push(x);
        } else {
            Integer previousMin = minStack.peek();
            if (x < previousMin) {
                minStack.push(x);
            } else {
                minStack.push(previousMin);
            }
        }
    }

    public void pop() {
        valueStack.pop();
        minStack.pop();
    }

    public int top() {
        return valueStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

public class No155 {
}
