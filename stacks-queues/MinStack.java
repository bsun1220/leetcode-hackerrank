import java.util.*;

class MinStack {
    ArrayList<Node> list;
    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int val) {
        int min = 0;
        if( list.size() == 0)
        {
            min = val;
        }
        else
        {
            Node last = list.get(list.size() - 1);
            min = Math.min(last.getMin(), val);
        }

        list.add(new Node(val, min));
    }

    public void pop() {
        list.remove(list.get(list.size() - 1));
    }

    public int top() {
        return list.get(list.size() - 1).getVal();
    }

    public int getMin() {
        return list.get(list.size() - 1).getMin();
    }
}
class Node{

    int myMin;
    int myVal;
    public Node(int val, int min)
    {
        myMin = min;
        myVal = val;
    }
    public int getMin(){return myMin;}
    public int getVal(){return myVal;}
}
