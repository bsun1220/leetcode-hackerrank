public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode start = new ListNode(-201, head);
        ListNode slow = start;
        while(slow != null && slow.next != null && slow.next.val < x){
            slow = slow.next;
        }

        ListNode fast = slow;

        while (fast != null && fast.next != null){
            if(fast.next.val < x){
                ListNode temp1 = slow.next;
                ListNode temp2 = fast.next.next;
                slow.next = fast.next;
                slow.next.next = temp1;
                slow = slow.next;
                fast.next = temp2;
            }
            else{
                fast = fast.next;
            }
        }
        return start.next;
    }
}
}
