public class BitAdd {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder("");
        StringBuilder asb = new StringBuilder(a).reverse();
        StringBuilder bsb = new StringBuilder(b).reverse();

        int length = Math.max(a.length(), b.length());

        boolean carry = false;
        int curr = 0;
        for(int i = 0; i < length; i++){
            int a_d = 0;
            int b_d = 0;
            if(i < a.length()){
                a_d = Integer.parseInt(asb.substring(i, i + 1));
            }
            if(i < b.length()){
                b_d = Integer.parseInt(bsb.substring(i, i + 1));
            }
            curr = a_d + b_d;
            if(carry){
                curr += 1;
                carry = false;
            }
            if(curr >= 2){
                curr = curr % 2;
                carry = true;
            }
            res.append(""+curr);
        }
        if(carry){
            res.append("1");
        }

        return res.reverse().toString();

    }
}
