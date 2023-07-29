package leetcode.datastructure;

import java.util.HashMap;

public class MyLinkedList {

    static class Node {

        public Node(int val) {
            this.val = val;
        }

        int val;

        Node next;

        Node prev;
    }

    private int size;

    private Node sentinel;

    public MyLinkedList() {
        size = 0;
        // 构建循环双向链表
        sentinel = new Node(-1);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public int get(int index) {
        if (index < size) {
            return getSpecificIndexNode(index).val;
        } else {
            return -1;
        }
    }

    public void addAtHead(int val) {
        Node newHead = new Node(val);
        Node oldHead = sentinel.next;

        sentinel.next = newHead;
        newHead.prev = sentinel;
        newHead.next = oldHead;
        oldHead.prev = newHead;
        size++;
    }

    public void addAtTail(int val) {
        Node newTail = new Node(val);
        Node oldTail = sentinel.prev;

        oldTail.next = newTail;
        newTail.prev = oldTail;
        newTail.next = sentinel;
        sentinel.prev = newTail;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
        } else if (index < size) {
            size++;
            Node node = getSpecificIndexNode(index);
            Node prevNode = node.prev;
            Node newNode = new Node(val);

            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = node;
            node.prev = newNode;
        } else {
            // 长度太大什么都不做
        }
    }

    public void deleteAtIndex(int index) {
        if (index < size) {
            size--;
            Node remove = getSpecificIndexNode(index);
            Node prevNode = remove.prev;
            Node nextNode = remove.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
    }

    private Node getSpecificIndexNode(int index) {
        Node result = sentinel.next;
        while (index != 0) {
            index--;
            result = result.next;
        }

        return result;
    }
}
