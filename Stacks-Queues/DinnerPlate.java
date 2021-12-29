import java.util.*;

class DinnerPlate {


    ArrayList<Stack<Integer>> list;
    int myCap;

    public DinnerPlate(int capacity) {
        list = new ArrayList<>();
        myCap = capacity;
    }

    public void push(int val) {
        for(Stack<Integer> s: list)
        {
            if(s.size() < myCap)
            {
                s.push(val);
                return;
            }
        }
        list.add(new Stack<Integer>());
        list.get(list.size() - 1).push(val);
    }

    public int pop() {
        if(list.size() == 0)
        {
            return -1;
        }
        for(int i = list.size() - 1; i >= 0; i--)
        {
            if(!list.get(i).isEmpty())
            {
                return list.get(i).pop();
            }
        }
        return -1;
    }

    public int popAtStack(int index) {
        if(index >= list.size() || list.get(index).isEmpty())
        {
            return -1;
        }
        return list.get(index).pop();
    }
}
