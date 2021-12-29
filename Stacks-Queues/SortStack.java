import java.util.*;

public class SortStack {
    Stack<Integer> mySorted;
    Stack<Integer> myInput;

    public static void main(String [] args)
    {
        SortStack s = new SortStack();
        s.push(2);
        s.push(5);
        s.push(1);
        s.push(3);
        s.push(1);
        s.push(11);
        s.push(13);

        while(!s.isEmpty())
        {
            System.out.println(s.pop());
        }
        s.push(23);
        s.push(25);
        s.push(11);
        s.push(32);
        s.push(123);
        s.push(121);
        s.push(113);

        System.out.println(s.peek());
        System.out.println(s.isEmpty());
    }

    public SortStack()
    {
        mySorted = new Stack<>();
        myInput = new Stack<>();
    }
    public void push(int val)
    {
        while(!mySorted.isEmpty() && mySorted.peek() < val)
        {
            myInput.push(mySorted.pop());
        }
        mySorted.push(val);
        while(!myInput.isEmpty())
        {
            mySorted.push(myInput.pop());
        }
    }
    public int pop()
    {
        return mySorted.pop();
    }
    public int peek()
    {
        return mySorted.peek();
    }

    public boolean isEmpty()
    {
        return mySorted.isEmpty();
    }
}
