package Stack;

//包含min函数的栈（或实现最小栈）

//题目描述：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数
//          在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

//复杂度分析：
//时间复杂度 O(1) ：push(), pop(), top(), min() 四个函数的时间复杂度均为常数级别。
//空间复杂度 O(N) ：当共有 N 个待入栈元素时，辅助栈 normal 最差情况下存储 N 个元素，
//                  使用 O(N) 额外空间

//示例：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();   --> 返回 0.
//minStack.min();   --> 返回 -2.

import java.util.Stack;
//时间复杂度O(1)        空间复杂度O(n)
public class MinStack_30 {

    Stack<Integer> normal;//正常栈
    Stack<Integer> min;   //最小栈
    /** initialize your data structure here. */
    public MinStack_30() {
        normal=new Stack<>();
        min=new Stack<>();
    }

    public void push(int x) {
        normal.push(x);
        if(min.isEmpty()){
            min.push(x);
        }else if(x<=min.peek()){
            min.push(x);
        }else {
            min.push(min.peek());
        }
    }

    public void pop() {
        normal.pop();
        min.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int min() {
        return min.peek();
    }
}