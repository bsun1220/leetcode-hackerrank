public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(new StringBuilder("()"), list, n, 1);
        return list;

    }

    public void backtrack(StringBuilder sb, List<String>list, int n, int end){
        if(sb.length() == 2 * n){
            list.add(sb.toString());
        }
        else{
            for(int remove = end; remove >= 0; remove--){
                sb.setLength(sb.length() - remove);
                sb.append("()");
                for(int i = 0; i < remove; i++){
                    sb.append(")");
                }
                if(sb.length() == 2 * n){
                    System.out.println(sb.toString());
                }

                backtrack(sb, list, n, remove + 1);

                sb.setLength(sb.length() - remove - 2);
                for(int i = 0; i < remove; i++){
                    sb.append(")");
                }

            }
        }

    }
}
