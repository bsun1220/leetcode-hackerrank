public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0 ; i < tokens.length; i++){
            String current = tokens[i];
            if(isEquation(current)){
                int second = s.pop();
                int first = s.pop();
                int num = operation(first, second, current);
                //System.out.println(num);
                s.push(num);
            }
            else{
                int num = Integer.parseInt(current);
                s.push(num);
            }
        }
        return s.pop();

    }

    public boolean isEquation(String word){
        return word.equals("*") || word.equals("+") ||word.equals("-") ||word.equals("/");
    }

    public int operation(int a, int b, String op){
        if(op.equals("*")){
            return a * b;
        }
        else if(op.equals("+")){
            return a + b;

        }
        else if(op.equals("-")){
            return a - b;
        }
        else {
            return a / b;
        }
    }
}
