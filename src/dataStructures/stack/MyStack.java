package dataStructures.stack;

public class MyStack {
    int[] stack;
    int top;
    int size;

    public MyStack(int n)
    {
        this.stack = new int[n];
        this.top = 0;
        this.size = n;
    }

    public boolean isEmpty()
    {
        return top == 0;
    }

    public boolean isFull()
    {
        return top == size;
    }

    public int top()
    {
        if (!isFull())
        {
            return stack[top-1];
        }
        return -1;
    }

    public boolean push(int item)
    {
        if (!isFull())
        {
            stack[top++] = item;
            return true;
        }
        return false;
    }

    public int pop()
    {
            return stack[--top];
    }

    public String show() {
        String result = "[";
        for(int i = 0; i < top; i++) {
            result += stack[i]+ ", ";
        }
        if(top > 0) {
            result = result.substring(0, result.length() - 2);
        }
        result+="]";
        return result;
    }
}
