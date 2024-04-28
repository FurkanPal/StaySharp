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
    }




