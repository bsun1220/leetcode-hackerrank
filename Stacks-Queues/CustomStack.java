public class CustomStack {
    int[] stack;
    int index;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        index = 0;
    }

    public void push(int x) {
        if(index >= stack.length){
            return;
        }
        stack[index] = x;
        index++;
    }

    public int pop() {
        if(index == 0){
            return -1;
        }
        index--;
        int val = stack[index];
        return val;
    }

    public void increment(int k, int val) {
        int length = Math.min(k, stack.length);
        for(int i = 0; i < length; i++){
            stack[i] += val;
        }
    }
}
