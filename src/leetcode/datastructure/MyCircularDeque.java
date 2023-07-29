package leetcode.datastructure;

public class MyCircularDeque {

    static class Node {

        public Node(int val) {
            this.val = val;
        }

        int val;

        Node next;

        Node prev;
    }

    private final int capacity;

    private int size;

    private final Node sentinel;

    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
        // 循环双向链表
        sentinel = new Node(-1);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            size++;

            Node node = new Node(value);
            Node oldHead = sentinel.next;

            sentinel.next = node;
            node.prev = sentinel;
            node.next = oldHead;
            oldHead.prev = node;

            return true;
        }
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            size++;

            Node node = new Node(value);
            Node oldTail = sentinel.prev;

            oldTail.next = node;
            node.prev = oldTail;
            node.next = sentinel;
            sentinel.prev = node;

            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            size--;

            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;

            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            size--;

            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;

            return true;
        }
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        } else {
            return sentinel.next.val;
        }
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        } else {
            return sentinel.prev.val;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
