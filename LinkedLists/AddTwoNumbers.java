public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1, null);
        ListNode iter = head;

        boolean carry = false;
        while(l1 != null || l2 != null || carry){
            int sum = carry ? 1 : 0;
            carry = false;

            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            if(sum > 9){
                carry = true;
                sum = sum % 10;
            }

            iter.next = new ListNode(sum, null);
            iter = iter.next;
        }

        return head.next;
    }
}
