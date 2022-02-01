class Node{
    public  int frequency; // the frequency of this tree
    public  char data;
    public  Node left, right;
}

public class HuffmanDecoding {
    void decode(String s, Node root) {
        StringBuilder decoded = new StringBuilder("");
        int index = 0;
        while(index < s.length()){
            Node iter = root;
            while(iter != null && (iter.left != null && iter.right != null)){
                if(s.charAt(index) == '0'){
                    iter = iter.left;
                }
                else{
                    iter = iter.right;
                }
                index++;
            }
            decoded.append(iter.data);
        }

        System.out.println(decoded.toString());
    }
}
