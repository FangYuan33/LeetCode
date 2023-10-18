package leetcode.priorityqueue;

/**
 * 小顶堆
 * 索引 1 处的节点为堆顶元素；某节点的两个子节点分别为 2i 和 2i + 1，父节点为 i / 2
 *
 * @author wangyilong13
 * @since 2023-10-18 16:52:26
 */
public class MyPriorityQueue {

    public static void main(String[] args) {
        MyPriorityQueue priorityQueue = new MyPriorityQueue(3);

        priorityQueue.offer(3);
        priorityQueue.offer(2);
        priorityQueue.offer(1);

        System.out.println(priorityQueue.poll());
    }

    int[] nums;

    int size;

    int capacity;

    public MyPriorityQueue(int n) {
        // 不使用 0 索引
        nums = new int[n + 1];
        this.capacity = n;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    /**
     * 获取堆顶元素，即最小值
     */
    public int peek() {
        if (size == 0) {
            return -1;
        }

        return nums[1];
    }

    /**
     * 元素入堆操作，先将该元素赋值在堆底，并不断地和比自己大的父节点交换位置
     */
    public void offer(int num) {
        if (size + 1 <= capacity) {
            nums[++size] = num;
            swim(size);
        }
    }

    /**
     * 由下至上堆有序化（上浮）
     */
    private void swim(int index) {
        while (index > 1 && nums[index] < nums[index / 2]) {
            swap(index, index / 2);
            index /= 2;
        }
    }

    /**
     * 元素出堆操作，将堆顶元素与堆底元素交换位置，并不断地和比自己小的子节点交换位置
     */
    public int poll() {
        if (size == 0) {
            return -1;
        }

        int res = nums[1];
        swap(1, size--);
        sink(1);

        return res;
    }

    /**
     * 由上至下堆有序化（下沉）
     */
    private void sink(int index) {
        while (index * 2 <= size) {
            int son = index * 2;
            if (son + 1 <= size && nums[son + 1] < nums[son]) {
                son++;
            }
            if (nums[index] > nums[son]) {
                swap(index, son);
                index = son;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
