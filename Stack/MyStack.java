package Stack;

import java.util.Arrays;

//顺序表简单实现栈
public class MyStack {
    //属性
    private int[] array;
    private int top;

    //构造方法
    public MyStack(int defaultCapacity){
        array=new int[defaultCapacity];
        top=0;
    }
    public MyStack(){
        this(20);
    }
    //入栈
    public void push(int val){
        if(top==array.length){
            array=Arrays.copyOf(array,array.length*2);
        }
        array[top++]=val;
    }
    //出栈
    public void pop(){
        if(top<0){
            System.out.println("栈为空，无法删除！");
            return;
        }
        top--;
        array[top]=0;// 可加可不加，把所有空的位置保持为 0
    }
    //返回栈顶元素
    public int peek(){
        if (top <= 0) {
            System.out.println("栈为空，无法返回栈顶元素");
            return -1;
        }
        return array[top-1];
    }
    //	返回栈内数据元素个数
    public int size() {
        return top;
    }
    //判断栈是否为空
    public boolean isEmpty() {
        return top == 0;
    }
}
