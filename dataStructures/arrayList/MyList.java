package dataStructures.arrayList;

import java.util.Arrays;

public class MyList {
    int[] list;
    int size;
    int len;

    public MyList(int s)
    {
        size = s;
        len = 0;
        list = new int[size];
    }

    public String show() {
        String result = "[";
        for(int i = 0; i < len; i++) {
            result += list[i]+ ", ";
        }
        if(len > 0) {
            result = result.substring(0, result.length() - 2);
        }
        result+="]";
        return result;
    }
    @Override
    public String toString() {
        return Arrays.toString(list);
    }

    public boolean add(int value)
    {
        if (size > len)
        {
            list[len] = value;
            len++;
            return true;
        }
        return false;
    }
    public boolean remove(int index)
    {
        if(index >= 0 && index < len)
        {
            for (int i = index; i < len; i++)
            {
                list[i] = list[i + 1]; // dich qua trai
            }
            len--;
            return true;
        }
        return false;
    }
    public boolean insert(int index, int value)
    {
        if (index >= 0 && index < len)
        {
            for (int i = len; i > index; i--)
            {
                list[i] = list[i - 1]; // dich qua phai
            }
            list[index] = value;
            len++;
            return true;
        }
        return false;
    }

    public boolean set(int index, int value)
    {
        if(index < len)
        {
            list[index] = value;
            return true;
        }
        return false;
    }
    public int get(int index)
    {
        if(index >= 0 && index < len) {
            return list[index];
        }
        return -1;
    }

    public int find(int value)
    {
        for(int i = 0; i < len; i++)
        {
            if(list[i] == value)
            {
                return i;
            }
        }
        return -1;
    }
    public boolean swap(int i1, int i2)
    {
        if (i1 >= len || i2 >= len)
        {
            return false;
        }
        else
        {
            int temp = list[i1];
            list[i1] = list[i2];
            list[i2] = temp;
//            list[i1] = list[i1] + list[i2];
//            list[i2] = list[i1] - list[i2];
//            list[i1] = list[i1] - list[i2];
            return true;
        }
    }
}
