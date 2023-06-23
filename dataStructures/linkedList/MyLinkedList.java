package dataStructures.linkedList;

public class MyLinkedList {
    Node head;
    Node current;
    int size;

    public MyLinkedList() {
        size = 0;
        head = current = null;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null && node.value != value) {
            node = node.next;
        }
        return node;
    }

    public Node addHead(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if (current == null) {
            current = newNode;
        }
        size++;
        return newNode;
    }

    public Node addAfter(int x, int value) // ... x là giá trị của 1 node cần tìm
    {
        Node nodeAfter = find(x); // tìm kiếm node để thêm node mới phía sau

        // HEAD-> ... -> nodeAfter -> nodeAfter2...
        if (nodeAfter == null) {
            return addHead(value);
        } else {
            Node newNode = new Node(value); // newNode
            newNode.next = nodeAfter.next; // newNode -> nodeAfter2
            nodeAfter.next = newNode; // nodeAfter -> newNode
            size++;
            return newNode;

            // HEAD-> ... -> nodeAfter -> newNode -> nodeAfter2...
        }

    }

    public Node add(int value) {
        // HEAD->A->B->NULL
        if (size > 0) {
            Node newNode = new Node(value); // tao C
            current.next = newNode; // B->C
            current = newNode; // B->C
            size++;
            return newNode;

            // HEAD->A->B->C->NULL
        } else {
            return addHead(value);
        }
    }

    public void remove(int value) {
        Node nodeX = find(value);
        // System.out.println("Node X"+nodeX);
        if (nodeX == null) {
            System.out.println("Not Found value");
        }
        // HEAD-> ... -> nodeA-> nodeB (x) -> nodeC -> NULL
        else if (size > 0) {
            Node nodeBeforeX = head;
            // System.out.println("head => "+head);

            while (nodeBeforeX.next != nodeX) {
                nodeBeforeX = nodeBeforeX.next; // nodeBeforeX = nodeA
            }
            // System.out.println("nodeBeforeX =>"+nodeBeforeX);
            nodeBeforeX.next = nodeX.next; // nodeA -> nodeC
            nodeX.next = null;
            nodeX = null;
            size--;
            // HEAD-> ... -> nodeA-> nodeC -> NULL
        } else {
            // System.out.println("Linked List Null");
        }
    }

    public boolean set(int value, int newValue) {
        Node node = find(value); // tìm kiếm node đầu tiên đê sửa
        // System.out.println(node);
        if (node == null) {
            return false;
        }
        node.value = newValue;
        return true;
    }

    public String show() {
        String result = "[";
        for (Node node = head; node != null; node = node.next) {
            result += node.value + ", ";
        }
        if (size > 0) {
            result = result.substring(0, result.length() - 2);
        }
        result += "]";
        return result;
    }
}
