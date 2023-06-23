package dataStructures.linkedList;

public class Node {
    public int value; // du lieu cua node nay
    public Node next; // dia chi cua node tiep theo

    Node(int v)
    {
        value = v;
        next = null;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + ", next=" + next + "]";
    }

}
