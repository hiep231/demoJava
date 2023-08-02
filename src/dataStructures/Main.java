package dataStructures;

import dataStructures.arrayList.MyList;
import dataStructures.linkedList.MyLinkedList;
import dataStructures.queue.MyQueue;
import dataStructures.stack.MyStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
////        List<Integer> myList = new ArrayList<>();
////        myList.add(1);
////        myList.add(2);
////        myList.add(3);
////
////        for (int item: myList) {
////            System.out.println(item);
////        }
//        MyList list = new MyList(10);
//        list.add(7);
//        list.add(8);
//        list.add(6);
//        list.add(8);
//        list.add(-2);
////        list.insert(3,10);
////        list.remove(1);
////        System.out.println(list.find(7));
//
//        list.swap(0,3);
//        System.out.println(list.show());

//        MyStack stack = new MyStack(4);
//        stack.push(2);
//        stack.push(4);
//        stack.push(5);
//        stack.push(7);
//
//        System.out.println(stack.pop());
//        System.out.println(stack.show());

//        MyQueue queue = new MyQueue();
//        queue.enQueue(7);
//        queue.enQueue(10);
//        queue.enQueue(8);
//        queue.deQueue();
//        System.out.println(queue.show());

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(5);
        linkedList.addHead(2);
        linkedList.addAfter(0,1);
        linkedList.add(6);

        System.out.println(linkedList.show());
    }
}
