package leetcode.queue;

public class MyCircularQueue {

    private final int[] nums;

    private int left;

    private int right;

    private int size;

    public MyCircularQueue(int k) {
        nums = new int[k];
        left = 0;
        right = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            // 进入队列右指针移动
            nums[right % nums.length] = value;
            right++;
            size++;

            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            // 出栈左指针移动
            left++;
            size--;

            return true;
        }
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return nums[left % nums.length];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return nums[(right - 1) % nums.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == nums.length;
    }

}
