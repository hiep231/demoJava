package dataStructures.queue;

public class MyQueue {
    Node head;
    Node current;

    public MyQueue() {
        head = current = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void front() {
        if (!isEmpty()) {
            System.out.println(head.value);
        } else {
            System.out.println("Queue Empty!");
        }
    }

    public void enQueue(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = current = newNode; // newNode vừa là đầu vừa là cuối
        } else {
            current.next = newNode;
            current = newNode;
        }
    }

    public void deQueue() {
        if (head == null) {
            System.out.println("Queue Empty!");
        }
        // head -> A -> B -> C -> NULL
        else {
            head = head.next;
        }

    }

    public String show() {
        String result = "[";
        for (Node node = head; node != null; node = node.next) {
            result += node.value + ", ";
        }
        if (head != null) {
            result = result.substring(0, result.length() - 2);
        }
        result += "]";
        return result;
    }
}
