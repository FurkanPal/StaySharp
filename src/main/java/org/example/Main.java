package org.example;

//import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(1);

        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        myLinkedList.append(6);
        myLinkedList.append(7);
        myLinkedList.append(8);

//        myLinkedList.removeDuplicates();
//        myLinkedList.partitionList(5);
        myLinkedList.reverseBetweeen(3,5);

//        myLinkedList.binaryToDecimal();
        // myLinkedList.floydHasLoop();
        // myLinkedList.createLoop();
        // myLinkedList.propend(3);
        // myLinkedList.findMiddle();
        // myLinkedList.reverse();
        // myLinkedList.remove(0);
        // myLinkedList.set(3,6);
        // myLinkedList.insert(12, 6);
        // myLinkedList.removeLast();
//         myLinkedList.removeFirst();
//        myLinkedList.printList();
    }
}