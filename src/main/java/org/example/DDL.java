package org.example;

public class DDL {
    private Node head;
    private Node tail;
    private int length;


    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value = value;
        }
    }

    public DDL(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }
    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead(){
        System.out.println(head.value);
    }
    public void getTail(){
        System.out.println(tail.value);
    }
    public void getLength(){
        System.out.println(length);
    }
    public void removeLast(){
        if (length == 0 || length == 1){
            head = null;
            tail = null;
        }else {
            Node temp = head;
                while(temp.next.next != null){
                    temp = temp.next;
                }
            tail = tail.prev;
            tail.prev = temp.prev;
            tail.next = null;
            length--;
        }
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        Node temp = head;
        if (length == 0) {
            head = newNode;
            tail = newNode;
        }else {
            head = newNode;
            head.next = temp;
            head.prev = null;
        }
        length++;
    }
    public void removeFirst(){
        if (length == 0 || length == 1){
            head = null;
            tail = null;
        }else{
            Node temp = head;
            head = head.next;
        }
        length--;
    }
    public Node get(int index){
        if (length == 0 || length == 1) return null;
        Node temp = head;
        int loop = 1;
        if (length <= index) return tail;
        while (temp.next != null && loop != index ){
            temp = temp.next;
            loop++;
        }
        return temp;
    }

    public void set(int index, int value){
        Node temp = get(index);
        if (temp != null){
            temp.value = value;
        }
    }
    public boolean remove(int index){
        if (length == 0)return false;
        if (index == length){
            removeLast();
        }
        Node temp = get(index -1);
        temp.next = get(index +1);
        length--;

        return true;
    }

    public void insert(int index, int value){
        if (index == 0){
            prepend(value);
        }
        if (length <= index){
            append(value);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++){
            temp = temp.next;
        }
        Node keepIt = temp.next;
        temp.next = new Node(value);
        temp.next.next = keepIt;
    }

    public void swapFirstLast(){
        if (length < 2) return;
        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    public void reverse(){
        Node temp = head;

        while (temp.next != null){
            temp = temp.next;
        }
    }

}









