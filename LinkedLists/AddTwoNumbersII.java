public class AddTwoNumbersII {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

        while(l1 != null){
        s1.push(l1.val);
        l1 = l1.next;
    }

        while(l2 != null){
        s2.push(l2.val);
        l2 = l2.next;
    }

    ListNode head = new ListNode(-1, null);
    ListNode iter = head;

    boolean carry = false;
        while(!s1.isEmpty() || !s2.isEmpty() || carry){
        int sum = carry ? 1 : 0;
        carry = false;

        if(!s1.isEmpty()){
            sum += s1.pop();
        }

        if(!s2.isEmpty()){
            sum += s2.pop();
        }

        if(sum > 9){
            sum = sum % 10;
            carry = true;
        }
        ListNode temp  = iter.next;
        iter.next = new ListNode(sum, temp);
    }

        return head.next;


}
}
