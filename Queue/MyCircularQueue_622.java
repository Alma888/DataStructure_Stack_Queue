package Queue;

//本题给了两种解法：数组+单链表实现
//时间复杂度O(1)  空间复杂度O(n)
public class MyCircularQueue_622 {
    //解法一：数组实现
    private int[] array;
    private int size;
    private int front;
    private int rear;
        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue_622(int k) {
            array=new int[k];
            size=0;
            front=0;
            rear=0;
        }

        //入队
        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if(size==array.length){
                return false;
            }
            array[rear]=value;
            rear=(rear+1)%array.length;
            size++;
            return true;
        }

        //出队
        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if(size==0){
                return false;
            }
            front=(front+1)%array.length;
            size--;
            return true;
        }

        //获取队首元素
        /** Get the front item from the queue. */
        public int Front() {
            if(size==0){
                return -1;
            }
            return array[front];
        }

        //获取队尾元素
        /** Get the last item from the queue. */
        public int Rear() {
            if(size==0){
                return -1;
            }
            int index = (rear + array.length - 1) % array.length;
            return array[index];
        }

        //判空
        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return size==0;
        }

        //判定队列是否是满的
        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return size==array.length;
        }
}

//解法二：单链表实现
/*
class Node {
  public int value;
  public Node nextNode;

  public Node(int value) {
    this.value = value;
    this.nextNode = null;
  }
}

class MyCircularQueue_622 {

  private Node head, tail;
  private int count;
  private int capacity;


public MyCircularQueue_622(int k) {
    this.capacity = k;
}

    public boolean enQueue(int value) {
        if (this.count == this.capacity) {
            return false;
        }

        Node newNode = new Node(value);
        if (this.count == 0) {
            head = tail = newNode;
        } else {
            tail.nextNode = newNode;
            tail = newNode;
        }
        this.count += 1;
        return true;
    }

    public boolean deQueue() {
        if (this.count == 0) {
            return false;
        }
        this.head = this.head.nextNode;
        this.count -= 1;
        return true;
    }

    public int Front() {
        if (this.count == 0) {
            return -1;
        } else {
            return this.head.value;
        }
    }

    public int Rear() {
        if (this.count == 0) {
            return -1;
        }else {
            return this.tail.value;
        }
    }

    public boolean isEmpty() {
        return (this.count == 0);
    }

    public boolean isFull() {
        return (this.count == this.capacity);
    }
}
*/