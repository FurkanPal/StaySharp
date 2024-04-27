package org.example;
import org.w3c.dom.Node;

import java.util.HashSet;
import java.util.Set;


public class LinkedList {
    private Node head;
    private Node tail;
    private int length;


    public void reverseBetweeen(int m, int n) {
        if (head == null) return;

        Node dummy = new Node(0);
        dummy.next = head;
        Node pre = dummy;

        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        Node start = pre.next;
//        System.out.println(pre.value);
        Node then = start.next;

//        System.out.println(start.next.value);
//        System.out.println(then.value);
//        System.out.println(then.value);
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        head = dummy.next;
    }


    class Node {
        int value;
        Node next;
        int length;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void propend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void removeFirst() {
        if (length == 0)
            return;
        if (length == 1) {
            head = null;
            tail = null;
        }
        if (length > 1) {
            head = head.next;
            length--;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        length++;
    }

    public Node get(int index) {
        if (index < 0 || index > length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i != index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length)
            return false;
        if (index == 0) {
            propend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        } else {
            Node newNode = new Node(value);
            Node temp = get(index - 1);
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
            return true;
        }
    }

    public boolean remove(int index) {
        if (index < 0 || index > length)
            return false;
        if (index == 0) {
            removeFirst();
            length--;
            return true;
        }
        if (index == length) {
            removeLast();
            length--;
        } else {
            Node temp = get(index - 1);
            temp.next = get(index + 1);
            length--;
        }
        return true;
    }

    public Node findMiddle() {
        int i = length / 2;
        return get(i);
    }

    public void createLoop() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
    }

    public boolean myhasLoop() {
        Node temp = head;
        int loopCounter = 0;
        while (temp.next != null) {
            temp = temp.next;
            loopCounter++;
            if (loopCounter >= length * 2) {
                System.out.println(loopCounter);
                return true;
            }
        }
        return false;
    }

    public boolean floydHasLoop() {
        Node tempFast = head;
        Node tempSlow = head;
        while (tempFast != null && tempFast.next != null) {
            tempSlow = tempSlow.next;
            tempFast = tempFast.next.next;

            if (tempFast == tempSlow) {
                System.out.println("has a loop");
                return true;
            }
        }
        System.out.println("has not a loop");
        return false;
    }

    public Node findKthFromEnd(int k) {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        if (length < k) {
            return null;
        }
        ;
        temp = head;
        for (int i = 0; i < length - k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node removeLast() {
        if (length == 0)
            return null;
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }


    public void partitionList(int x) {
        if (head == null) return;
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        Node prev1 = dummy1;
        Node prev2 = dummy2;

        Node current = head;
        while (current != null) {
            if (x > current.value) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                /* prev2 on the down below its keeping the last nodes so
                   on the next iteration it ll know where we were left and
                   prev.next will work...                               */
                prev2 = prev2.next;
            }
            current = current.next;
        }
        prev2.next = null;
        System.out.println(prev2.value);
        prev1.next = dummy2.next;
        System.out.println(dummy2.next.value);
        head = dummy1.next;
    }

    public int binaryToDecimal() {
        Node temp = head;
        int counter = 0;
        int sum = 0;
        int num = 0;
        while (temp != null) {
            num = counter * 2;
            num += temp.value;
            sum = num;
            counter++;
            temp = temp.next;
        }
        return sum;
    }
    public void removeDuplicates() {
        Set<Integer> values = new HashSet<>();
        Node prev = null;
        Node current = head;
        while (current != null) {

            if (values.contains(current.value)) {
                prev.next = current.next;
                length--;
            } else {
                values.add(current.value);
                prev = current;
            }
            current = current.next;
        }
    }

}