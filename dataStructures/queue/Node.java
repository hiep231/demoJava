package dataStructures.queue;

public class Node {
    public int value;
    public Node next;

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
