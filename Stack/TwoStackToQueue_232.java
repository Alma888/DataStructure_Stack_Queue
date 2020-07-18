package Stack;

//用栈实现队列
//题目描述：使用栈实现队列的下列操作：
//push(x) -- 将一个元素放入队列的尾部。
//pop() -- 从队列首部移除元素。
//peek() -- 返回队列首部的元素。
//empty() -- 返回队列是否为空。

//示例:
//MyQueue queue = new MyQueue();
//queue.push(1);
//queue.push(2);
//queue.peek();  // 返回 1
//queue.pop();   // 返回 1
//queue.empty(); // 返回 false

//说明:
//你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
//你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
//假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。

import java.util.Stack;

public class TwoStackToQueue_232 {
    private Stack<Integer> out;//出的栈（上图中左边的）
    private Stack<Integer> in;//入的栈（上图中右边的）
    public TwoStackToQueue_232(){
        out=new Stack<>();
        in=new Stack<>();
    }

    public void push(int x){
        in.push(x);//尾插
    }

    public int pop(){
        if(out.isEmpty()) {
            while(!in.isEmpty()){
                out.push(in.pop());//将从in栈里出来的元素，再添加到out栈里去，实现顺序颠倒
            }
        }
        return out.pop();
    }

    public int peek(){
        if(out.isEmpty()) {
            while(!in.isEmpty()){
                out.push(in.pop());//将从in栈里出来的元素，再添加到out栈里去，实现顺序颠倒
            }
        }
        return out.peek();//返回最后一个元素即可
    }

    public boolean empty(){
        return out.isEmpty() && in.isEmpty();
    }
}
