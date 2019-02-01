package leetcode.queue.circularQueue;

/**
 *
 *
 * 循环队列
 * head为对首，tail为队尾
 * @author stevenw
 * @date 2019/2/1
 */
public class MyCircularQueue {


    private int size;
    private int head;
    private int tail;
    private int [] arr;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        arr = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            head = 0;
        }
        tail = (tail + 1)%size;
        arr[tail] = value;

        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(head == tail){
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return arr[head];

    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return arr[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail + 1) % size == head;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(4);//false
        myCircularQueue.Rear(); //3
        myCircularQueue.isFull();//true
        myCircularQueue.deQueue();  // 返回true
        myCircularQueue.enQueue(4);  // true
        myCircularQueue.Rear(); //4
    }
}
