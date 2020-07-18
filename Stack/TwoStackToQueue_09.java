package Stack;

import java.util.Stack;

//用两个栈实现队列
//题目描述：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数
//          appendTail 和 deleteHead ，分别完成在队列尾部插入整数 和
//          在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

//示例 1：
//输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
//示例 2：
//输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]

public class TwoStackToQueue_09 {
    //思路：维护两个栈，第一个栈支持插入操作，第二个栈支持删除操作。
    //
    //根据栈先进后出的特性，我们每次往第一个栈里插入元素后，第一个栈的底部元素
    //是最后插入的元素，第一个栈的顶部元素是下一个待删除的元素。为了维护队列
    // 先进先出的特性，我们引入第二个栈，用第二个栈维护待删除的元素，在执行
    // 删除操作的时候我们首先看下第二个栈是否为空。如果为空，我们将第一个栈
    // 里的元素一个个弹出插入到第二个栈里，这样第二个栈里元素的顺序就是待删除
    // 的元素的顺序，要执行删除操作的时候我们直接弹出第二个栈的元素返回即可。

    //复杂度分析：
    // 时间复杂度：对于插入和删除操作，时间复杂度均为 O(1)。插入不多说，
    //             对于删除操作，虽然看起来是 O(n) 的时间复杂度，但是
    //             仔细考虑下每个元素只会「至多被插入和弹出 out 一次」，
    //             因此均摊下来每个元素被删除的时间复杂度仍为 O(1)。
    //空间复杂度：O(n)。需要使用两个栈存储已有的元素。

    private Stack<Integer> out; //出的栈
    private Stack<Integer> in;  //入的栈

    public TwoStackToQueue_09() {
        out=new Stack<>();
        in=new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        int deleteH;
        if(out.isEmpty()){
            int size=in.size();
            for(int i=0;i<size;i++){
                int v=in.pop();
                out.push(v);//将从in栈里出来的元素，再添加到out栈里去，实现顺序颠倒
            }
        }
        if(out.isEmpty()){
            return -1;
        }else{
            deleteH=out.pop();
        }
        return deleteH;
    }
}

